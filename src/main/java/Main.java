import java.math.BigDecimal;
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


public class Main {
    public static void main(String[] args) {

        // password file
        InputStream is;

        try {
            is = new FileInputStream("password.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error, password file not found");
            e.printStackTrace();
        }

        // read password
        final String password;
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            password = buf.readLine();
        } catch (IOException e) {
            System.out.println("Error reading password input");
            e.printStackTrace();
        }


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

        // mail client setup
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("tlee753server", password);
                    }});

        // mail message setup
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tlee753server@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    // InternetAddress.parse("8606708284@vzwpix.com")); // JON
                    // InternetAddress.parse("4702634639@message.ting.com")); // LAUREN
                    // InternetAddress.parse("7705708727@vzwpix.com")); // BRANDON
                    InternetAddress.parse("6787391126@vzwpix.com"));

            // email
            message.setSubject("Testing Java App");
            message.setText(

                "Stop being a bitch clues, start investing: \n" +
                messageString.toString()

            );

            // send message
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
* TODO make a string building class (desired stock info)
* TODO move elements to seperate methods
* TODO two way capability
* TODO other features
* - sports scores
* - map directions
* - messages (FB,etc)
* -
*/