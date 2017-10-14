from yahoo_finance import Share

microsoft = Share("amzn")
nvidia = Share("NVDA")

print "Nvidia Open: ", nvidia.get_price()
print nvidia.get_200day_moving_avg()
print nvidia.get_trade_datetime()
print nvidia.get_change()
print nvidia.get_historical('2017-9-9', '2017-10-10')

print nvidia.get_market_cap()
print microsoft.get_market_cap()

# growth (linear)
# volatility measurement
# how steady has the growth been (all at once or fairly distributed)
