use source_info;

#Obtendo o numero da Release
SET @release_number = (SELECT substring_index('?','.',1));

#Obtendo o id da Release
SET @idRelease = (SELECT idRelease from D_Release where release_number = @release_number);

#Obtendo a linguagem de programacao do Projeto
SET @Project_Language = (SELECT project_language from D_Project);

#Obtendo o Id do Projeto
SET @idProject = (SELECT max(idProject) from D_Project);

#Verificando no Metadados a Range do ACCM
SET @idACCM = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='ACCM' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do AMLOC
SET @idAMLOC = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='AMLOC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do ANPM
SET @idANPM = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='ANPM' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do CBO
SET @idCBO = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='CBO' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do LCOM4
SET @idLCOM4 = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='LCOM4' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do NPA
SET @idNPA = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='NPA' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do NOC
SET @idNOC = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='NOC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando no Metadados a Range do RFC
SET @idRFC = (SELECT idMetricRange FROM Meta_Metric_Ranges
where language_name =  @Project_Language 
and metric_name='RFC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

#Verificando a existencia de Classe Pouco Coesa
SET @idClassePoucoCoesa = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idLCOM4 
and  Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange2 = @idRFC);

#Verificando a existencia de Interface dos Metodos
SET @idInterfaceMetodos = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idANPM);

#Verificando a existencia de Classe com muitos Filhos
SET @idClasseFilhos = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idNOC);

#Verificando a eistencia de Classe Grande
SET @idClasseGrande = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idACCM 
and Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange2 = @idAMLOC);

#Verificando a Existencia de Classe Exposta
SET @idClasseExposta = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idNPA);

#Verificando a Existencia de Complexidade Estrutural
SET @idComplexidadeEstrutural = (SELECT `Meta_Scenario`.`idMeta_Scenario`
FROM `Meta_Metric_Ranges_Meta_Scenario` INNER JOIN Meta_Scenario ON Meta_Scenario.idMeta_Scenario = Meta_Metric_Ranges_Meta_Scenario.Meta_Scenario_idMeta_Scenario where 
Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange1 = @idCBO 
and  Meta_Metric_Ranges_Meta_Scenario.Meta_Metric_Ranges_idMetricRange2 = @idLCOM4);

#Criando uma Tabela Temporaria para receber os Cenarios
DROP TABLE IF EXISTS Temporary_F_Scenario_Class ;
CREATE Temporary TABLE  `source_info`.`Temporary_F_Scenario_Class` (
  `idScenarioFact` INT NOT NULL AUTO_INCREMENT,
  `quantity_Scenario` INT NULL,
  `D_Scenario_Clean_Code_idScenario` INT NULL,
  `D_Project_idProject` INT NULL,
  `D_Release_idRelease` INT NULL,
  `D_Class_idClass` INT  NULL,
  PRIMARY KEY (`idScenarioFact`))
ENGINE = InnoDB;

#Inserindo o Fato de Classe Pouco Coesa na Tabela Temporaria
INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idClassePoucoCoesa, @idProject, @idRelease, ?);

#Inserindo o Fato de Interface dos Metodos na Tabela Temporaria

INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idInterfaceMetodos, @idProject, @idRelease, ?);


#Inserindo o Fato Classe com Muitos Filhos na Tabela Temporaria
INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idClasseFilhos, @idProject, @idRelease, ?);


#Inserindo o Fato da Classe com Metodos Grandes ou muitos condicionais na Tabela Temporaria
INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idClasseGrande, @idProject, @idRelease, ?);


#Inserindo o Fato da Classe muito exposta na Tabela Temporaria
INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idClasseExposta, @idProject, @idRelease, ?);

#Inserindo o Fato da Classe com grande complexidade estrutural na Tabela Temporaria
INSERT INTO `source_info`.`Temporary_F_Scenario_Class`
(`quantity_Scenario`,`D_Scenario_Clean_Code_idScenario`,
`D_Project_idProject`,
`D_Release_idRelease`,
`D_Class_idClass`)
VALUES
(1, @idComplexidadeEstrutural, @idProject, @idRelease, ?);


#Copiando da Tabela Temporaria para Tabela Fato apenas os que nao sao nulos
INSERT INTO F_Scenario_Class (`F_Scenario_Class`.`quantity_Scenario`,`F_Scenario_Class`.`D_Scenario_Clean_Code_idScenario`,
`F_Scenario_Class`.`D_Project_idProject`,
`F_Scenario_Class`.`D_Release_idRelease`,
`F_Scenario_Class`.`D_Class_idClass`) SELECT`Temporary_F_Scenario_Class`.`quantity_Scenario`,`Temporary_F_Scenario_Class`.`D_Scenario_Clean_Code_idScenario`,
`Temporary_F_Scenario_Class`.`D_Project_idProject`,
`Temporary_F_Scenario_Class`.`D_Release_idRelease`,
`Temporary_F_Scenario_Class`.`D_Class_idClass` FROM Temporary_F_Scenario_Class where Temporary_F_Scenario_Class.D_Scenario_Clean_Code_idScenario is not null;

#Calculando o total de cenarios na release
SET @total_scenarios = (SELECT COUNT(*)FROM source_info.F_Scenario_Class where D_Release_idRelease= @idRelease);

#Calculando a Taxa de Aproveitamento de Oportunidades de Melhoria de Codigo-Fonte
SET @rate = (@total_scenarios/?);

#Criando uma Tabela Temporaria que recebera a Taxa, numero de Classes e Quantidade de Cenarios
DROP TABLE IF EXISTS `Temporary_F_Rate_Scenario`;
CREATE Temporary TABLE `Temporary_F_Rate_Scenario` (
  `idRateScenario` int(11) NOT NULL AUTO_INCREMENT,
  `RateScenario` double DEFAULT NULL,
  `Quantiy_Scenarios` double DEFAULT NULL,
  `numberOfClasses` int(11) DEFAULT NULL,
  `D_Project_idProject` int(11) NOT NULL,
  `D_Release_idRelease` int(11) NOT NULL,
  PRIMARY KEY (`idRateScenario`))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

#Inserindo na Tabela Temporaria a Taxa, numero de Classes e Quantidade de Cenarios
INSERT INTO `source_info`.`Temporary_F_Rate_Scenario`
(`RateScenario`,`Quantiy_Scenarios`, `numberOfClasses`,
`D_Project_idProject`, `D_Release_idRelease`)
VALUES
(@rate,@total_scenarios,?,@idProject, @idRelease);

#Passando os dados da Tabela Temporaria para Tabela Fato
REPLACE INTO `source_info`.`F_Rate_Scenario`
SET `RateScenario` = @rate, `numberOfClasses`= ?, `Quantiy_Scenarios` = @total_scenarios, 
`D_Release_idRelease` = @idRelease, `D_Project_idProject`=@idProject;
