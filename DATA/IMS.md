# IMS

# DATABASE
- MySQL
- Name : POSIMSBasic

# BASIC IMS 
## TABLES FOR POS

```sql

CREATE TABLE Product (
productID INT AUTO_INCREMENT NOT NULL,
productName VARCHAR(50),
productDescription VARCHAR(50),
productPurchasePrice DECIMAL(18, 2),
productSellingPrice DECIMAL(18, 2),
productQuantity INT,
productActive INT,
PRIMARY KEY (productID)
);

```


