from yahoo_finance import Share

Yahoo = Share("YHOO")
Nvidia = Share("NVDA")
print "Yahoo Open: ", Yahoo.get_price()
print "Nvidia Open: ", Nvidia.get_price()
