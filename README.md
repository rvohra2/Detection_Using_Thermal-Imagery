# PEDESTRIAN/ ANIMAL/ POTHOLE DETECTION USING THERMAL IMAGERY: 
This project aims at development of smart traffic lights for both efficient traffic management and pedestrians safety. In this project thermal camera is placed at traffic lights and the live feed is send to our server. On our server the pedestrians are detected and a count is generated.
If the count is greater than a set threshold,the traffic LED will be switched on/off accordingly. 

## Getting started:
Raspberry pi are easily available in the market and the software used for it is Raspbian operating system that can be downloaded from https://www.raspberrypi.org/ .
Flir one camera is product of flir company that can installed with the android processor.

### Prerequisites:
1. A computer/server
2. Raspberry pi.
3. Thermal camera.
4. Traffic LEDs
5. Python processing tools
6. Flir one app

### Installing:
1. Install the Flir one app from google play store on your android processor
2. open the background service,give the IP address of the server,then click on start service to initiate background service
3. Open the Flir one app and turn on the thermal camera to start capturing videos
4. Install the raspbian os on raspberry pi-
a.	Visit www.raspberrypi.org and click on the DOWNLOADS button in the navigation bar, at the top of the screen.
b.	We will see a box which contains a link to the raspbian files. Click on the link.
c.	Download the zip archive of the files.
d.	Go to our Downloads folder and find the zip file.
e.	Right-click on the the zip file and select Extract All... from the context menu

5. Setting up local host server to update data dynamically
a.      Disabling the desktop environment:Type the command:sudo raspi-config
b.      Securing your Raspberry Pi:In Raspi-config, arrow down to ‘Change password for pi user‘. You will now be asked to enter a new password for pi user
c.      Enabling SSH:In Raspi-config, arrow down to ‘SSH‘ and hit enter. You’ll be asked if you want to enable SSH, choose ‘enable’. Done!

6. Installing Apache, PHP and MySQL on Raspberry Pi
a.      Ensure you’re running the latest system software. To check for updates and install them enter the following command: “sudo apt-get update"
b.      Install Apache:(i)To do this its begin with entering:“sudo bash”This means we’re not having to type sudo each time we run a command. 
                       (ii)When you’ve done this, enter the following: “apt-get install apache2 apache2-doc apache2-utils".
                       (iii)Once complete, enter the following command:“apt-get install libapache2-mod-php5 php5 php-pear php5-xcache”.
                       (iv)Follow up with installing the support package for database connectivity:“apt-get install php5-mysql”
                       (v)install MySQL server. Do this by entering the following command:“apt-get install mysql-server mysql-client”

7. Installing Python:
Steps given below indicate how to check whether python is already installed and if not, it will install python: 
a.	In the command prompt, type python and press the enter key. If Python is there, we should see it start up. If we saw Python start up, skip to the next section. If we saw an error message instead, follow the steps below to add Python to our PATH.
b.	In the Windows search bar, type in python.exe, but don't click on it in the menu. Instead, right click on it and select Open file location.
c.	A window should open up with some files and folders: this is where the Python is installed. Right click on the address bar at the top and select Copy address as text.
d.	Right-click on the file called Python 3.x (where 3.x is the version number of our Python installation) and select Open file location until we see a folder containing a file called python.exe.
e.	From the main Windows menu, open the Control Panel.
f.	In the search box on the top right, type in environment, then in the search results click on Edit environment variables for our account.
g.	If there is already a variable listed called Path, click on it to select it, then click Edit.... If it does not exist, instead click New...
h.	Click New and then paste in the address we copied earlier. Then click New again, paste in the address again, and add Scripts\ at the end. Press OK twice to finish editing environment variables.
i.	If there is only a single line for variable value, paste in the address, type a semicolon (;), paste in the address again, and add Scripts\ at the end. Press OK to finish editing environment variables.
j.	Once again, type in python at the command prompt and press the Enter key. We should now see Python start successfully. Press Ctrl + c to exit the Python shell.
Installing pip:
a.	Now that we can use Python from the command line, and therefore make use of pip:
b.	At the command prompt, type the following command to upgrade pip: Python –m pip install –U pip
c.	Now we can use pip! We can install libraries using the pip install command. For example, if we wanted to download the guizero  library we would type this:Pip install guizero
d.	To install pip packages: Pip install gpzero

8. After all necessary installations connect the led's with the raspberry pi and implement the image processing tools.

### Running the tests:
STEP 1-Data is collected by fixing flir one thermal camera on android smart phone
STEP 2-A background service by using android studio is developed, whose work is to send the data
captured on the camera to the server.
STEP 3-A server is created which uses php script files on which the data from camera is stored
STEP 4-Data stored on the server is accessed by raspberry pi
STEP 5-On raspberry pi, extraction of images and detection of pedestrians happens and count is
generated
STEP 6- LED’s(which act as traffic lights) are interfaced with raspberry pi and they glow according
to the count generated

## Authors:
* **Rhythm Vohra** **Sahil Sharad**
