# Final assignment for programming mobile devices module 

![image](https://user-images.githubusercontent.com/44726497/155218126-f14b25cb-eb5d-4c37-b783-1f874f86a5a0.png)
![image](https://user-images.githubusercontent.com/44726497/155218702-569d70e6-1815-4a56-baac-f16d610b3c80.png)
![image](https://user-images.githubusercontent.com/44726497/155218790-85dd1958-fb78-4c61-a149-85a6ec8248e0.png)

## Requirements: 
 
1. Create a online shopping app .  
 
2. You can choose any of the following: 
* Fashion  
* Sports items 
* Groceries 
* Arts and Hobbies 
* Music instruments 
 
3. Your main activity should display a tabview for selecting subcategories of items 
available to shop from at least three categories. Clicking on each tab should open a 
fragment with recyclerview list of at least 5 items based on chosen category.  You 
can create a list for each category in main activity and load into fragment based on 
tab clicked. 
 
4. For this fragment, Each row in the recyclerview should have an image of the item 
and its name, code and price in a textviews placed below image. Each item should 
also have either of the following  
 
a. A button for adding it to basket.  
                            or 
b. A pop up menu to add item to basket or wish list 
 
5. Create a database helper class to create database for application and two tables 
inside it and all CRUD methods for each table 
a. One with columns id, username , password, address 
b. One with itemname, item code and item price  
 
6. App should have an options menu on each activity with options for  
 
a. Signing in  
b. Open basket 
c. Go to home page 
 
7. When user chooses an option to sign in a new activity should open with two edittext 
views for user name and password respectively and two buttons one for signing in 
and one for signing up.   
 
8. If user puts in text for user name and password then click sign in, check if the user 
name exists in first table then check if the password matches the password in the 
table. If both match correctly then 
