from PIL import Image
import numpy as np

img=Image.open("490485.jpg")
arr=np.array(img)
print(arr.shape)