# POS
How to run Point Of Sale System for the grocery store.

![grocery grapes](https://raw.githubusercontent.com/heathermortensen/POS/master/images/grapes.png)

**Step 1.)** The POS system begins by outputting an Inventory Report in a text file named InventoryReportOutput.txt. The report contains the grocery store’s initial inventory.

![](https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_1_program_output.png)

**Step 2.)** The cashier is prompted to enter their credentials. The following credentials will be accepted by the system.

| Username | Password |
| -------- | -------- |
| alm4204  | 2468A    |
| khan0033 | 1234C    |
| mort0048 | mK167B   |
| zho1751  | 135B     |

The cashier logs in. Then, selects from a menu of options.

<img src="https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_2_program_output.png" style="zoom:67%;" />



**Step 3.)** The cashier enters 5 to view the store inventory.

![Store Inventory](https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_3_program_output.png)

**Step 4.)** The cashier enters '1' to begin checking out a customer. 

​			Checkout proceeds by entering a cycle of barcode numbers and the quantity of each item.

![](https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_4_program_output.png)

**Step 5.)** Here we see that the initial sale of the day on register #1 has concluded when the cashier enters 'N'.

<img src="https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_5_program_output.png" alt="Sale reciept" style="zoom:150%;" />

**Step 6.)**  The sale is finalized when the cashier enters 2.

![conclusion of a sale](https://raw.githubusercontent.com/heathermortensen/POS/master/images/image_6_program_output.png)

There are several reports created during this process. They include: 1.) A cashier report; 2.) A cash register report; and, 3.) An Inventory report. When inventory dips below a specified threshold, the system generates a flag to prompt the store to reorder stock.

A cash register report is shown here. It is generated in the file named CashRegisterReport.txt.

![Cash Register report](https://github.com/heathermortensen/POS/blob/master/images/image_7_program_output.png)