# LibraryTracker
Work in progress.

Simple program to track a card library, or a library of any type.

With time, I intend to integrate a web crawler into the app, in order to look up prices in cardmarket.eu, so as to update a small local database of prices pertaining to cards in the library.

Implemented features:

	-Adding/Removing cards to/from a library
	-Listing cards in a library
	-Saving and loading a library
	-Looking up a given card's lowest price

WIP (in sort of an order of priority, I guess idk):

	-Looking up prices for all cards in the library;
	-Maintaining a small local database of card prices;
	-Adding bought card price
	-Ordering cards by their locally stored price;
	-Ordering cards by profit
	-Fixing weird urls for old alternative card rarities in sets;
	-Fix weird url for starlight rare alternative rarity cards;
	-Detecting fluctuations in price;
	-Alerting the user of said fluctuations;
	-Remove the need for "(V.X - <Rarity Y>)" in the card name, in the case of an alternative rarity;
	-Detecting typos in input and guessing the intended input;

