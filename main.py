class Book:
    def __init__(self, title, author, price):
        self.title = title
        self.author = author
        self.price = price

    def __str__(self):
        return f"Book: {self.title} | Author: {self.author} | Price: {self.price}"

class Ebook(Book):
    def __init__(self, title, author, price, file_size_mb):
        super().__init__(title, author, price)
        self.file_size_mb = file_size_mb 

    def __str__(self):
        return f"Ebook -> {super().__str__()} | MB: {self.file_size_mb}"
class Product:
    def __init__(self, product_name, price):
        self.product_name = product_name
        self.price = price
        
    def __str__(self):
        return f"Product: {self.product_name} \nPrice: {self.price}"

class ElectronicProduct(Product):
    def __init__(self, product_name, price, warranty_months):
        super().__init__(product_name, price)
        self.warranty_months = warranty_months
        
    def __str__(self):
        return f"Electronic {super().__str__()} \nWarranty_months: {self.warranty_months} months"

class Laptop(ElectronicProduct): 
    def __init__(self, product_name, price, warranty_months, ram_gb, storage_gb):
        super().__init__(product_name, price, warranty_months)
        self.ram_gb = ram_gb
        self.storage_gb = storage_gb
        
    def __str__(self):
        return f"{super().__str__()} \nRam: {self.ram_gb} GB \nStorage: {self.storage_gb} GB"

def main():
    books = [
        Book("Python Basics", "Maria Santos", 450),
        Ebook("Learning OOP", "Ana Cruz", 300, 5)
    ]
    for book in books:
        print(book)

    laptops = [
        Laptop("Lenovo Laptop", 35000, 24, 16, 512)
    ]
    for item in laptops:
        print(item)

if __name__ == "__main__":
    main()