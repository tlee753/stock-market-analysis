import java.io.*;
import java.util.Map;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Main extends Key {
    public static void main(String[] args) {



        // stock initialition
        Stock apple, boeing, bankOfAmerica, costco, disney, electronicArts, intel, generalElectric, microsoft, netflix, nike,
                nvidia, phillips66, schlumberger, royalDutchShell, tesla, verizon, visa, yahoo;
        apple = boeing = bankOfAmerica = costco = disney = electronicArts = intel = generalElectric = microsoft = netflix = nike
                = nvidia = phillips66 = schlumberger = royalDutchShell = tesla = verizon = visa = yahoo = null;
        Map<String, Stock> stocks = null;

        // get stock info
        try {
            String[] symbols = new String[] {"AAPL", "BA", "BAC", "COST", "DIS", "EA", "INTC", "GE", "MSFT",
                    "NFLX", "NKE", "NVDA", "PSX", "SLB", /*"RDS.A",*/ "TSLA", "V", "VZ", "YHOO"};
            stocks = YahooFinance.get(symbols); // single request
            apple = stocks.get("AAPL");
            boeing = stocks.get("BA");
            bankOfAmerica = stocks.get("BAC");
            costco = stocks.get("COST");
            disney = stocks.get("DIS");
            electronicArts = stocks.get("EA");
            intel = stocks.get("INTC");
            generalElectric = stocks.get("GE");
            microsoft = stocks.get("MSFT");
            netflix = stocks.get("NFLX");
            nike = stocks.get("NKE");
            nvidia = stocks.get("NVDA");
            phillips66 = stocks.get("PSX");
            schlumberger = stocks.get("SLB");
            // royalDutchShell = stocks.get("RDS.A");
            tesla = stocks.get("TSLA");
            visa = stocks.get("V");
            verizon = stocks.get("VZ");
            yahoo = stocks.get("YHOO");
        } catch (IOException e) {
            System.out.println("Error retrieving Stock Information");
            e.printStackTrace();
        }

        StringBuilder messageString = new StringBuilder(0);
        // get stock prices
        for (Map.Entry<String, Stock> stock : stocks.entrySet())
        {
            messageString.append(stock.getKey());
            messageString.append(": ");
            messageString.append(stock.getValue().getQuote().getPrice().toString());
            messageString.append("\n");
        }

        // Refrence for stock methods
        // http://financequotes-api.com/javadoc/yahoofinance/quotes/stock/StockQuote.html


}

/*
* xTODO make a string building class (desired stock info)
* TODO move elements to seperate methods
* TODO allow for command line arguments to be passed in for server side ease of use
* TODO create a user object with stocks and how to contact them
* TODO two way capability
* TODO other features
* - sports scores
* - map directions
* - messages (FB,etc)
* -
*/