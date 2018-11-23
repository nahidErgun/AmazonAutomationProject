Getting Started with Gauge
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`


Adding Product to Wish List
---------------------------
tags:addingProductToWishList

* Login with "username" and "password" informations.
* If wish list is not empty, remove all products.
* Search for "samsung" text and check the search result accuracy
* Go to "2"'nd page then verify the url contains "pg_2?".
* Select "3"'rd product from the results
* Keep product title
* Add product to wishlist
* Go to wish list page
* Compare product title on wish list with the recorded title
* Delete product from wish list
