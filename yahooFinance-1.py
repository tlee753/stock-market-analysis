from yahoo_finance import Share

yahoo = Share("YHOO")
nvidia = Share("NVDA")

print "Yahoo Open: ", yahoo.get_price()
print "Nvidia Open: ", nvidia.get_price()
print "===="
print nvidia.get_info()

print yahoo.get_historical('2014-04-25', '2014-04-29')
