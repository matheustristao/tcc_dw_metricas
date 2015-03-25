#coding: utf-8
import os
import csv
import linecache

vetor_metricas = ['acc','accm','amloc','an','anpm','asom','auv','bd','bf','cbo','da','dbz','df','dit','dnp','dupv','fgbo','lcom4','loc','mlk','mmloc','noa','noc','nom','npa','npm','obaa','osf','pitfc','rfc','rogu','rsva','saigv','sc','ua','uaf','uav']

for metrica in vetor_metricas:

	print(metrica)

	#Aqui eu pego o nome dos projetos, que serão salvos em cada linha da planilha

	PATH = "/home/pedro/Desktop/shared/ptcu/"

	#Aqui eu listo tudo que está nesse diretório
	list_names = os.listdir(os.path.expanduser(PATH))

	project_names = []

	#Aqui eu percorro a lista de nomes e pego só o nome dos projetos, que não terminam com .csv
	for name in list_names:
		if name.find(".csv") <1:
			project_names.append(name)

	# crio o arquvo csv	
	myfile = open(metrica + '.csv', 'wb')
	
	wr = csv.writer(myfile, quoting=csv.QUOTE_MINIMAL, delimiter=';' )

	#header do csv
	wr.writerow(['Projeto','Mínimo','1%','5%','10%','25%','50%','75%','90%','95%','99%','Máximo'])

	for project_name in project_names:
				
		#Aqui eu abro a pasta do projeto e o arquivo de métrica que eu quero exatamente na segunda linha
		linha = project_name  + ' ' + linecache.getline(PATH + project_name + "/" + metrica + '.txt', 2)	

		#Aqui o split cria o vetor que vai ser tratado na funcao writerow(), que aplica os delimitadores para cada argumento do array
		wr.writerow(linha.split())	