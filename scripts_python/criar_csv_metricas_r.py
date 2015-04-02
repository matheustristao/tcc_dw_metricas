#coding: utf-8
import os
import csv
import linecache

vetor_metricas = ['acc','accm','amloc','an','anpm','asom','auv','bd','bf','cbo','da','dbz','df','dit','dnp','dupv','fgbo','lcom4','loc','mlk','mmloc','noa','noc','nom','npa','npm','obaa','osf','pitfc','rfc','rogu','rsva','saigv','sc','ua','uaf','uav']

# Lista de projetos a serem aproveitados
list_projects = ['agendadortarefas-details','assinatura-details','assinaturaBatch-details','consisteNegocio-details','edependencia-details','eprocIS-details','eprocIS-impl-details','indexaged-details','lumis-details','mesatrabalho-details','portaltextual-details','pushportalbatch-details','pushprocessos-details','SGS-Ti-details','sinc.cliente.provisionamento-details','sinc.lumis-details','sinc.oid-details','sorteio-details','treatsvn-details','adp-details','alertas-details','atospessoal-details','atosPessoalAdm-details','avaliar-details','beneficiocontrole-details','busca-details','cadicon-details','cadirreg-details','catalogoServicos_fabrica-details','cats-details','cbex-details','certidao-details','clientela-details','consultaremuneracao-details','contrata-details','cpl-details','debito-details','delfos-details','ecomBatch-details','ecomWeb-details','econsulta-details','econtrole-details','ecopia-details','edoc-details','egestao-details','encclaWebService-details','eproc-details','equalidade-details','eSocial-details','etcu-details','evista-details','fiscalis-details','fiscalis2-details','folhapagamento-details','grh-details','intMavenFlip-details','juris-details','jusis-details','maci-details','monitoramento-details','mp-details','ndigi-details','patrimonio-details','pegasus-details','portal-details','processus-details','pushPortal-details','radar-details','reconhecer-details','sagas-details','sagas2-details','sequas-details','sequaswatcher-details','siga-details','sinc.ad-details','sinc.apex-details','sinc.biblioteca-details','sinc.comum-details','sinc.oracle-details','sinc.processo-details','sinc.servicedesk-details','sincservicedesk-details','sisac3-details','siscontas-details','sisdoc-details','sisunidade-details','sonar-plugin-tcu-details','sso-details','transcon_fabrica-details','transcon-details','transcon2_fabrica-details','tvo-details','wscatraca-details']


#Lista de valores LOC
list_loc = ['1374','2975','1746','1696','0','0','8','305','18876','0','4851','787','2451','0','41','916','1601','527','1125','43029','1017','7306','45932','33506','10023','225','14177','7195','0','2714','10383','1756','10559','718','4183','3856','3190','15942','6256','14875','13143','3867','1614','52105','57045','1628','104293','1405','0','12556','241','326305','666','37375','116444','444','62697','15712','1958','354','25092','435','129766','30841','15773','59284','1530','94798','2038','80184','141394','5937','2263','99542','4237','165','2507','4404','1686','1665','2410','4549','181987','1718','26033','4444','1083','3248','6057','6347','3516','6554','53']

#Lista de valores NOC
list_noc = ['6','2','2','6','0','0','0','0','12','0','11','0','2','0','0','0','7','0','9','15','0','2','362','100','37','1','5','1','0','0','5','9','16','6','28','0','6','14','21','72','68','1','8','156','118','3','0','12','0','6','0','482','6','121','344','0','227','86','5','0','85','1','197','44','42','46','5','247','0','166','781','0','4','221','24','2','4','33','2','9','22','22','166','4','31','28','25','0','27','8','48','0','0' ]

for metrica in vetor_metricas:

	#Aqui eu pego o nome dos projetos, que serão salvos em cada linha da planilha

	PATH = "/home/matheus/Documents/ptcu/saida_r_percentis/"

	# crio o arquvo csv	
	myfile = open(metrica + '.csv', 'wb')
	
	wr = csv.writer(myfile, quoting=csv.QUOTE_MINIMAL, delimiter=';' )

	#header do csv
	wr.writerow(['Projeto','Mínimo','1%','5%','10%','25%','50%','75%','90%','95%','99%','Máximo','LOC','NOC']) 


	for project_name in list_projects:
		
		posicao_loc_noc = list_projects.index(project_name)
		print(project_name + " " +  str(posicao_loc_noc))

		#Aqui eu abro a pasta do projeto e o arquivo de métrica que eu quero exatamente na segunda linha
		linha = project_name  + ' ' + linecache.getline(PATH + project_name + "/" + metrica + '.txt', 2)
		new_line = list_loc[posicao_loc_noc] + " " + list_noc[posicao_loc_noc]		

		#Aqui o split cria o vetor que vai ser tratado na funcao writerow(), que aplica os delimitadores para cada argumento do array
		wr.writerow(linha.split() + new_line.split())	

		if posicao_loc_noc == 18:
			wr.writerow("COM TESTE")	