import os
import linecache
from ezodf import newdoc, Sheet


vetor_metricas = ['ua', 'mmloc', 'acc', 'da', 'sc', 'mlk', 'rfc', 'uaf', 'saigv', 'amloc', 'an', 'cbo', 'anpm', 'rsva', 'asom', 'osf', 'npm', 'auv', 'obaa', 'noa', 'lcom4', 'nom', 'dbz', 'pitfc', 'dnp', 'bd', 'dit', 'npa', 'fgbo', 'dupv', 'bf', 'noc', 'accm', 'loc', 'df', 'uav', 'rogu']

for metrica in vetor_metricas:

	print(metrica)

	#Aqui eu crio a estrutura da planilha
	ods = newdoc(doctype='ods', filename= metrica + '.ods')

	sheet = Sheet('SHEET', size=(100, 12))

	ods.sheets += sheet

	sheet['B1'].set_value("Min")
	sheet['C1'].set_value("1%")
	sheet['D1'].set_value("5%")
	sheet['E1'].set_value("10%")
	sheet['F1'].set_value("25%")
	sheet['G1'].set_value("50%")
	sheet['H1'].set_value("75%")
	sheet['I1'].set_value("90%")
	sheet['J1'].set_value("95%")
	sheet['K1'].set_value("99%")
	sheet['L1'].set_value("Máx")

	vetor_posicoes = ['B','C','D','E','F','G','H','I','J','K','L']

	#Aqui eu pego o nome dos projetos, que serão salvos em cada linha da planilha

	PATH = "/home/matheus/Desktop/ptcu/"

	#Aqui eu listo tudo que está nesse diretório
	list_names = os.listdir(os.path.expanduser(PATH))

	project_names = []

	#Aqui eu percorro a lista de nomes e pego só o nome dos projetos, que não terminam com .csv
	for name in list_names:
		if name.find(".csv") <1:
			project_names.append(name)

	#Aqui eu crio uma linha na planilha para cada projeto
	valor_nome_projeto = 2
	posicao_linha = 2

	for project_name in project_names:
		cell = 'A' + str(valor_nome_projeto)
		sheet[cell].set_value(project_name)

		
		posicao_coluna = 0
		#Aqui eu abro a pasta do projeto e o arquivo de métrica que eu quero exatamente na segunda linha
		linha = linecache.getline(PATH + project_name + "/" + metrica + '.txt', 2)	
		
		#Aqui eu separo os valores da linha em variaveis separadas	
		valores_linha = linha.split()	

		#Pra cada valor eu coloco o conteúdo na célula
		for valor_linha in valores_linha:

			sheet[vetor_posicoes[posicao_coluna]+str(posicao_linha)].set_value(valor_linha)
			
			posicao_coluna = posicao_coluna + 1

		posicao_linha = posicao_linha + 1	
		valor_nome_projeto = valor_nome_projeto+1

	ods.save()