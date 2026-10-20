// ============================================================
//  OOP LAB ACTIVITY # 2  -  Library System (Java Swing)
//  File name must be:  LibrarySystem.java
//
//  The user types:  total pages, pages read
//  The user picks:  Issue Date and Due Date from a calendar
//  The program shows:
//     1. the percentage of the book already read
//     2. how many days are left to return the book
//     3. how many pages to read every day to finish the book
//
//  No extra libraries needed - the calendar pop-up is built in below.
// ============================================================

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LibrarySystem {

    // Change this to your own name (it shows in the "Welcome ..." label)
    static final String STUDENT_NAME = "Your Name";

    // ------------------------------------------------------------
    //  CalendarDialog: a small pop-up window that shows one month.
    //  Click a day button to choose that date.
    // ------------------------------------------------------------
    static class CalendarDialog extends JDialog {
        private YearMonth shown;                 // the month currently displayed
        private LocalDate chosen = null;         // the date the user clicked
        private final JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
        private final JPanel grid = new JPanel(new GridLayout(0, 7, 2, 2));

        CalendarDialog(Window owner, LocalDate start) {
            super(owner, "Select a date", Dialog.ModalityType.APPLICATION_MODAL);
            shown = YearMonth.from(start);

            JButton prev = new JButton("<");
            JButton next = new JButton(">");
            prev.addActionListener(e -> { shown = shown.minusMonths(1); refresh(); });
            next.addActionListener(e -> { shown = shown.plusMonths(1);  refresh(); });

            JPanel top = new JPanel(new BorderLayout());
            top.add(prev, BorderLayout.WEST);
            top.add(monthLabel, BorderLayout.CENTER);
            top.add(next, BorderLayout.EAST);

            setLayout(new BorderLayout(5, 5));
            add(top, BorderLayout.NORTH);
            add(grid, BorderLayout.CENTER);

            refresh();
            setLocationRelativeTo(owner);
        }

        // Redraws the grid of days for the month being shown
        private void refresh() {
            monthLabel.setText(shown.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                    + " " + shown.getYear());
            grid.removeAll();

            String[] names = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
            for (String n : names) grid.add(new JLabel(n, SwingConstants.CENTER));

            // Blank cells before the 1st of the month (Sunday = 0 blanks)
            int blanks = shown.atDay(1).getDayOfWeek().getValue() % 7;
            for (int i = 0; i < blanks; i++) grid.add(new JLabel(""));

            for (int day = 1; day <= shown.lengthOfMonth(); day++) {
                final LocalDate date = shown.atDay(day);
                JButton b = new JButton(String.valueOf(day));
                b.setMargin(new Insets(2, 2, 2, 2));
                if (date.equals(LocalDate.now())) {          // highlight today
                    b.setFont(b.getFont().deriveFont(Font.BOLD));
                }
                b.addActionListener(e -> { chosen = date; dispose(); });
                grid.add(b);
            }
            grid.revalidate();
            grid.repaint();
            pack();
        }

        LocalDate getChosen() { return chosen; }
    }

    // ------------------------------------------------------------
    //  DatePicker: a text box + a button that opens the calendar
    // ------------------------------------------------------------
    static class DatePicker extends JPanel {
        static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MMM d, yyyy");
        private LocalDate selected;
        private final JTextField field = new JTextField(9);

        DatePicker(LocalDate initial) {
            selected = initial;
            field.setEditable(false);                 // user must use the calendar
            field.setText(FORMAT.format(selected));

            JButton button = new JButton("...");
            button.setMargin(new Insets(1, 4, 1, 4));
            button.addActionListener(e -> {
                CalendarDialog dialog = new CalendarDialog(
                        SwingUtilities.getWindowAncestor(this), selected);
                dialog.setVisible(true);              // waits here until the pop-up closes
                if (dialog.getChosen() != null) {
                    selected = dialog.getChosen();
                    field.setText(FORMAT.format(selected));
                }
            });

            add(field);
            add(button);
        }

        LocalDate getDate() { return selected; }
    }

    // ------------------------------------------------------------
    //  The calculation. Returns the message to show, or an error
    //  message starting with "ERROR:" if something is wrong.
    // ------------------------------------------------------------
    static String buildMessage(int totalPages, int pagesRead,
                               LocalDate issueDate, LocalDate dueDate, LocalDate today) {

        if (totalPages <= 0)         return "ERROR: The book must have at least 1 page.";
        if (pagesRead < 0)           return "ERROR: Pages read cannot be negative.";
        if (pagesRead > totalPages)  return "ERROR: Pages read cannot be more than the total pages.";
        if (dueDate.isBefore(issueDate))
                                     return "ERROR: The due date cannot be before the issue date.";

        DecimalFormat df = new DecimalFormat("0.##");

        // 1. Percentage of the book already read
        double percent = pagesRead * 100.0 / totalPages;

        // Days the user has been reading (issue date up to today)
        long daysReading = Math.max(0, ChronoUnit.DAYS.between(issueDate, today));

        // 2. Days remaining until the due date (never below 0)
        long daysRemaining = Math.max(0, ChronoUnit.DAYS.between(today, dueDate));

        // 3. Pages left, and pages to read every day (rounded UP so the book gets finished)
        int pagesLeft = totalPages - pagesRead;

        String msg = "You have read " + df.format(percent) + "% of the book.\n"
                   + "You have been reading for " + daysReading + " day(s).\n"
                   + "You have " + daysRemaining + " day(s) remaining to return the book.\n";

        if (pagesLeft == 0) {
            msg += "You already finished the book. Great job!";
        } else if (daysRemaining == 0) {
            msg += "You still have " + pagesLeft + " page(s) left and today is the last day, "
                 + "so you should read all " + pagesLeft + " page(s) today.";
        } else {
            long perDay = (long) Math.ceil((double) pagesLeft / daysRemaining);
            msg += "You still have " + pagesLeft + " page(s) left and you should read "
                 + perDay + " pages a day.";
        }
        return msg;
    }

    // ------------------------------------------------------------
    //  Builds the window
    // ------------------------------------------------------------
    static void createWindow() {
        JFrame frame = new JFrame("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome " + STUDENT_NAME, SwingConstants.CENTER);
        welcome.setFont(welcome.getFont().deriveFont(Font.BOLD));

        JTextField pagesField = new JTextField(10);
        JTextField readField  = new JTextField(10);
        DatePicker issuePicker = new DatePicker(LocalDate.now());
        DatePicker duePicker   = new DatePicker(LocalDate.now().plusDays(14));
        JButton calculate = new JButton("Calculate");

        // Layout: a grid with 2 columns (left = pages, right = dates)
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 15, 5, 15);
        c.gridx = 0; c.gridy = 0; form.add(new JLabel("How many pages does the book have?"), c);
        c.gridx = 1; c.gridy = 0; form.add(new JLabel("Issue Date"), c);
        c.gridx = 0; c.gridy = 1; form.add(pagesField, c);
        c.gridx = 1; c.gridy = 1; form.add(issuePicker, c);
        c.gridx = 0; c.gridy = 2; form.add(new JLabel("How many pages have you read?"), c);
        c.gridx = 1; c.gridy = 2; form.add(new JLabel("Due Date"), c);
        c.gridx = 0; c.gridy = 3; form.add(readField, c);
        c.gridx = 1; c.gridy = 3; form.add(duePicker, c);

        JPanel bottom = new JPanel();
        bottom.add(calculate);

        // What happens when the Calculate button is clicked
        calculate.addActionListener(e -> {
            int total, read;
            try {
                total = Integer.parseInt(pagesField.getText().trim());
                read  = Integer.parseInt(readField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter whole numbers for the pages.",
                        "Invalid input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result = buildMessage(total, read,
                    issuePicker.getDate(), duePicker.getDate(), LocalDate.now());

            if (result.startsWith("ERROR:")) {
                JOptionPane.showMessageDialog(frame, result.substring(7),
                        "Invalid input", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, result,
                        "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(welcome, BorderLayout.NORTH);
        frame.add(form, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);   // center on the screen
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibrarySystem::createWindow);
    }
}