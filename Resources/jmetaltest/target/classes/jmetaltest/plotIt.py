import pandas as pd
from matplotlib import pyplot as plt
from matplotlib import cm
import numpy as np

# set up a figure twice as wide as it is tall
fig = plt.figure(figsize=plt.figaspect(0.5))


columns = ["x", "y"]
df = pd.read_csv("/Users/grisv/GitHub/KanoaV2/Resources/jmetaltest/FUN.csv", names=columns)
print("/Users/grisv/GitHub/KanoaV2/Resources/jmetaltest/FUN.csv", df.head())
plt.plot(df.x, df.y,'.')
plt.show()

columns = ["x", "y","z"]
df = pd.read_csv("/Users/grisv/GitHub/KanoaV2/Resources/jmetaltest/VAR.csv", names=columns)
print("/Users/grisv/GitHub/KanoaV2/Resources/jmetaltest/VAR.csv", df.head())
