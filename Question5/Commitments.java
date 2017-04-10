

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
        /**
	 * Makes commitments according to constraints , handles gift exchange.
	 * @author AnkitSingh Bisen
	 *
	 */

public class Commitments {

    public static int MatchMaker(boy[] boys, int b, girl[] girls, int g, gift[] gifts, int gif, int allocations[][], String[][] Logdata) {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");     //For date and time stamp purposes. 
        Date dateobj = new Date();
        int a = 0;
        int turn = 0;
        int p = 0, q, z, l = 0, m, max = -1;
        int i, j, k;
        System.out.println("WHO-CHOSE-WHO DETAILS: \n");
        while ((p <= g - 1) || (l <= b - 1)) {
            if (p <= g - 1) {
                for (q = 0; q < b; q++) {

                    if ((boys[q].budget > girls[p].Maintbudget) && (girls[p].attractiveness > boys[q].minatreq) && (boys[q].relstat == 's') && (girls[p].relstat == 's')) {

                        boys[q].relstat = 'c';
                        girls[p].relstat = 'c';
                        System.out.println(df.format(dateobj) + "\n\t->  " + girls[p].name + " chose " + boys[q].name);
                        allocations[a][0] = q;
                        allocations[a][1] = p;

                        i = p;
                        j = q;

                        Logdata[a][0] = (df.format(dateobj) + "\n" + "Commitment Details:" + "\n" + "\t" + "boy" + (allocations[a][0]+1) + " and " + "girl" + (allocations[a][1]+1) + " get committed." + "\n \n");
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
                p++;
            }

            if (l <= b - 1) {
                for (z = 0; z < g; z++) {
                    for (m = 0; m < g; m++) {
                        if ((girls[m].attractiveness > max) && (girls[m].relstat == 's')) {

                            max = m;

                        }
                    }
                    if (max == -1) {
                        break;
                    }
                    if ((girls[z].attractiveness >= girls[max].attractiveness) && (girls[z].relstat == 's') && (boys[l].relstat == 's')) {

                        boys[l].relstat = 'c';
                        girls[z].relstat = 'c';
                        System.out.println(df.format(dateobj) + "\n\t->  " + boys[l].name + " chose " + girls[z].name +".");
                        allocations[a][0] = l;
                        allocations[a][1] = z;

                        i = z;
                        j = l;

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
                l++;
            }
            max = -1;

        }
        return a;
    }
}
