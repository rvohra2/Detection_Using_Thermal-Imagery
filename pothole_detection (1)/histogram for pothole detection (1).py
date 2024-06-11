import cv2 #import opencv library
import numpy as np #import numpy library
from matplotlib import pyplot as plt #to create plot,import matplotlib
img = cv2.imread('C:\Python27\images\eg23.jpg') # directory hgiven to read image
color = ('b','g','r') # bgr colour specification 
for i,col in enumerate(color):#it helps to have an automatic counter
    histr = cv2.calcHist([img],[i],None,[256],[0,256])#histogram coordinates
    plt.plot(histr,color = col)# creates plot by colour comparison
    plt.xlim([0,256])# to set the x axis limits
plt.show()# to display the graph
