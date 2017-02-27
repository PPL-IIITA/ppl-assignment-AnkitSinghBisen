package pplq2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// -------THIS CLASS ASSIGNS COMMITMENTS AND PREPARES THE GIFT BASKET.

public class CommitmentsGifts {

    public static int CommitandGift(boy[] boys, girl[] girls, gift[] gifts, int allocations[][], int b, int g, int gif, String Logdata[][]) {

        //sorting the array of gifts in ascending order
        int i, j;

        gift temp = new gift();
        gift min = new gift();
        
        //SORTING THE GIFTS IN ASCENDING ORDER OF PRICE.
        for (i = 0; i < gif; i++) {

            min = gifts[i];
            for (j = i; j < gif; j++) {

                if (gifts[j].price < min.price) {

                    temp = min;
                    min = gifts[j];
                    gifts[j] = temp;
                }

            }
            gifts[i] = min;
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        //ASSIGNING COMMITMENTS AND GIFT BASKET.
        int a = 0;
        int k;
        for (i = 0; i < g; i++) {

            for (j = 0; j < b; j++) {

                if ((boys[j].budget > girls[i].Maintbudget) && (girls[i].attractiveness > boys[j].minatreq) && (boys[j].relstat == 's')) {

                    boys[j].relstat = 'c';
                    girls[i].relstat = 'c';
                    allocations[a][0] = j;
                    allocations[a][1] = i;

                    Logdata[a][0] = (df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + allocations[a][0] + " and " + "girl" + allocations[a][1] + " get committed." + "\n");
                    boys[j].numberofgiftsgiven = 0;

                    if ((boys[j].type).equals("Miser")) {

                        for (k = 0; k < gif; k++) {

                            if (boys[j].numberofgiftsgiven == 0 && gifts[0].price > boys[j].budget) {
                                boys[j].budget = gifts[0].price;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;

                            } else if (gifts[k].price + boys[j].giftsgiventotalprice > boys[j].budget && boys[j].giftsgiventotalprice < girls[i].Maintbudget) {

                                boys[j].budget = gifts[k].price + boys[j].giftsgiventotalprice;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                boys[j].numberofgiftsgiven++;
                                break;
                            } else if (gifts[k].price + boys[j].giftsgiventotalprice < boys[j].budget && boys[j].giftsgiventotalprice + gifts[k].price > girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;
                            } else if (boys[j].giftsgiventotalprice + gifts[k].price < girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                boys[j].numberofgiftsgiven++;

                            }

                        }
                        Logdata[a][1] = Integer.toString(boys[j].numberofgiftsgiven);

                        boys[j].happiness = boys[j].budget - boys[j].giftsgiventotalprice;

                    } else if ((boys[j].type).equals("Generous")) {

                        for (k = 0; k < gif; k++) {

                            if (boys[j].numberofgiftsgiven == 0 && gifts[0].price > boys[j].budget) {
                                boys[j].budget = gifts[0].price;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;

                            } else if (gifts[k].price + boys[j].giftsgiventotalprice > boys[j].budget && boys[j].giftsgiventotalprice < girls[i].Maintbudget) {

                                boys[j].budget = gifts[k].price + boys[j].giftsgiventotalprice;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;
                            } else if (gifts[k].price + boys[j].giftsgiventotalprice < boys[j].budget && boys[j].giftsgiventotalprice + gifts[k].price > girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                boys[j].numberofgiftsgiven++;

                            } else if (boys[j].giftsgiventotalprice + gifts[k].price < girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                boys[j].numberofgiftsgiven++;

                            } else if (boys[j].giftsgiventotalprice > girls[i].Maintbudget && boys[j].giftsgiventotalprice + gifts[k].price > boys[j].budget) {
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                            }
                            break;

                        }
                        Logdata[a][1] = Integer.toString(boys[j].numberofgiftsgiven);

                    } else if ((boys[j].type).equals("Geeks")) {

                        for (k = 0; k < gif; k++) {

                            if (boys[j].numberofgiftsgiven == 0 && gifts[0].price > boys[j].budget) {
                                boys[j].budget = gifts[0].price;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;

                            } else if (gifts[k].price + boys[j].giftsgiventotalprice > boys[j].budget && boys[j].giftsgiventotalprice < girls[i].Maintbudget) {

                                boys[j].budget = gifts[k].price + boys[j].giftsgiventotalprice;
                                boys[j].giftsgiventotalprice = boys[j].budget;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;
                            } else if (gifts[k].price + boys[j].giftsgiventotalprice < boys[j].budget && boys[j].giftsgiventotalprice + gifts[k].price > girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                                boys[j].numberofgiftsgiven++;
                                break;
                            } else if (boys[j].giftsgiventotalprice + gifts[k].price < girls[i].Maintbudget) {
                                boys[j].giftsgiventotalprice += gifts[k].price;
                                boys[j].numberofgiftsgiven++;

                            }

                        }

                        while (k < gif) {

                            if ((gifts[k].type).equals("Luxury")) {
                                break;
                            } else {
                                k++;
                            }

                        }

                        if (gifts[k].price + boys[j].giftsgiventotalprice < boys[j].budget) {
                            boys[j].giftsgiventotalprice += gifts[k].price;
                            girls[i].giftstakentotalprice = boys[j].giftsgiventotalprice;
                        }
                        Logdata[a][1] = Integer.toString(boys[j].numberofgiftsgiven);

                        boys[j].happiness = ((int) (girls[i].intlevel)) * 100;

                    }

                    int cost = 0;
                    if ((girls[i].type).equals("Choosy")) {
                        for (k = 0; k < boys[j].numberofgiftsgiven; k++) {
                            if ((gifts[k].type).equals("Luxury")) {
                                cost = cost + (2 * gifts[k].price);
                            } else {
                                cost = cost + gifts[k].price;
                            }
                        }

                        girls[i].happiness = (int) Math.log((double) (cost - girls[i].Maintbudget));

                        if ((boys[j].type).equals("Generous")) {
                            girls[i].couplehappiness = 2 * girls[i].happiness;
                        } else {
                            girls[i].couplehappiness = boys[j].happiness + girls[i].happiness;
                        }

                        girls[i].couplecompat = (boys[j].budget - girls[i].Maintbudget) + Math.abs(girls[i].attractiveness - boys[j].attractiveness) + Math.abs(boys[j].intelligence - girls[i].intlevel);

                    } else if ((girls[i].type).equals("Normal")) {
                        cost = 0;
                        for (k = 0; k < boys[j].numberofgiftsgiven; k++) {
                            cost = cost + gifts[k].price + Math.round(gifts[k].value);

                        }
                        girls[i].happiness = cost - girls[i].Maintbudget;

                        if ((boys[j].type).equals("Generous")) {
                            girls[i].couplehappiness = 2 * girls[i].happiness;
                        } else {
                            girls[i].couplehappiness = boys[j].happiness + girls[i].happiness;
                        }

                        girls[i].couplecompat = (boys[j].budget - girls[i].Maintbudget) + Math.abs(girls[i].attractiveness - boys[j].attractiveness) + Math.abs(boys[j].intelligence - girls[i].intlevel);

                    } else if ((girls[i].type).equals("Desperate")) {
                        cost = 0;
                        for (k = 0; k < boys[j].numberofgiftsgiven; k++) {
                            cost = cost + gifts[k].price;

                        }

                        girls[i].happiness = (int) Math.exp((double) (cost));

                        if ((boys[j].type).equals("Generous")) {
                            girls[i].couplehappiness = 2 * girls[i].happiness;
                        } else {
                            girls[i].couplehappiness = boys[j].happiness + girls[i].happiness;
                        }

                        girls[i].couplecompat = (boys[j].budget - girls[i].Maintbudget) + Math.abs(girls[i].attractiveness - boys[j].attractiveness) + Math.abs(boys[j].intelligence - girls[i].intlevel);
                    }

                    a++;
                    break;
                }

            }
        }

        return a;

    }

}
