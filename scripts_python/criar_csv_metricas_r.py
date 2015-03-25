#coding: utf-8
import os
import csv
import linecache



vetor_metricas = ['acc', 'rfc','da', 'sc', 'mlk', 'uaf', 'saigv', 'ua', 'mmloc', 'amloc', 'an', 'cbo', 'anpm', 'rsva', 'asom', 'osf', 'npm', 'auv', 'obaa', 'noa', 'lcom4', 'nom', 'dbz', 'pitfc', 'dnp', 'bd', 'dit', 'npa', 'fgbo', 'dupv', 'bf', 'noc', 'accm', 'loc', 'df', 'uav', 'rogu']

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

	#Aqui eu crio uma linha na planilha para cada projeto
	posicao_linha = 2

	
	myfile = open(metrica + '.csv', 'wb')
	
	wr = csv.writer(myfile, quoting=csv.QUOTE_MINIMAL, delimiter=';' )

	#header do csv
	wr.writerow(['Projeto','Mínimo','1%','5%','10%','25%','50%','75%','90%','95%','99%','Máximo'])

	for project_name in project_names:
				
		#Aqui eu abro a pasta do projeto e o arquivo de métrica que eu quero exatamente na segunda linha
		linha = linecache.getline(PATH + project_name + "/" + metrica + '.txt', 2)	
		linha = project_name  + ' ' + linha
		#Aqui eu separo os valores da linha em variaveis separadas	
		valores_linha = linha.split()			
					
		wr.writerow(valores_linha)

	