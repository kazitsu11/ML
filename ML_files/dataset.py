import pandas as pd
import numpy as np

df = pd.DataFrame(np.random.randint(1, 101, (20, 5)),
                  columns=["C1", "C2", "C3", "C4", "C5"])

df.to_csv("dataset.csv")

