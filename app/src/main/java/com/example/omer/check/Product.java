package com.example.omer.check;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Omer on 07/03/2018.
 */

public class Product implements Serializable, Comparable<Product> {

    int precent;
    String nameOfProduct;
    String companyName;
    int totalWrranty;
    String warrantyDetails;

    public Product(int precent, String name, int totalWrranty, String companyName) {
        this.precent = precent;
        this.nameOfProduct = name;
        this.totalWrranty = totalWrranty;
        this.companyName = companyName;
        warrantyDetails = "תקנות הגנת הצרכן בעניין אחריות ושירות לאחר מכירה הינן תקנות בעלות חשיבות רבה מאוד לחיים הצרכניים במדינת ישראל, העשויות לשפר באופן משמעותי את מצבו של הצרכן הישראלי. \n" +
                " \n" +
                " יודגש כי התקנות לא כוללות חפצים יקרי ערך שונים כמו: כלי נגינה, תכשיטים, שטיחים, ריהוט, מוצרי סניטציה ועוד.\n" +
                " \n" +
                "בשנת האחריות, על היצרן לתקן מוצר בתוך עשרה ימי עסקים מהיום שבו נמסר המכשיר למעבדה. במקרה של סירוב לתקן את המכשיר בתקופת האחריות בתקופה שנקבעה, בית המשפט רשאי לפסוק לטובת הצרכן פיצוי ללא הוכחת נזק בסכום של עד 10,000 ₪.\n" +
                "\n" +
                "לכן, מומלץ בשלב ראשון להעלות את הטענות על הכתב ולתאר את השתלשלות העניינים מול החברה ולציין כי במקרה של סירוב בית המשפט רשאי לפסוק לטובתך פיצוי לדוגמא בסך של 10,000 ₪. \n" +
                "מומלץ לשלוח את הפניה לחברה בדואר רשום או בפקס ולתעד את המשלוח.";
    }

    public int getPrecent() {
        return this.precent;
    }

    public String getNameOfProduct() {
        return this.nameOfProduct;
    }

    public int getTotalWrranty() {
        return this.totalWrranty;
    }

    public String getCompany() {
        return companyName;
    }

    public String getWarrantyDetails() {
        return this.warrantyDetails;
    }

    @Override
    public int compareTo(Product o) {
        return this.getPrecent() - o.getPrecent();
    }
}
