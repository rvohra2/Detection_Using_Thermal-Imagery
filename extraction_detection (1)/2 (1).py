import cv2 #import opencv library
print(cv2.__version__) #print opencv version
vidcap = cv2.VideoCapture('FLIR.mp4') #capture the given video by using cv2.VideoCapture command
success,image = vidcap.read()# read the captured video frames
count = 0 #initialize count
success = True #initialize variable success
while success: # run loop until the frame is being extracted
  success,image = vidcap.read() # read the captured video frames
  print 'Read a new frame: ', success #print true message is the frames are being extracted
  cv2.imwrite("C:\images/frame%d.jpg" % count, image)     # save frame as JPEG file
  count += 1 #increase count
