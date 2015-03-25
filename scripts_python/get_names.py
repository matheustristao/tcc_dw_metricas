import os

PATH = "/home/matheus/Desktop/ptcu/"

list_names = os.listdir(os.path.expanduser(PATH))

quantidade = 0
new_list_names = []

for name in list_names:
	if name.find(".csv") >1:
		name = name[:-4]
		
		new_list_names.append(name)
		quantidade = quantidade+1

print(sorted(new_list_names))		
print("\n" + str(quantidade))		
