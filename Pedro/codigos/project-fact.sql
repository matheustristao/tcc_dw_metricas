USE source_info;

SET @idProject = (SELECT max(idProject) from D_Project);

SET @idTime = (SELECT max(idTime) from D_Time);

SET @idRelease = (SELECT max(idRelease) from D_Release);

SET @Project_Language = (SELECT project_language from D_Project);

SET @Best_Configuration  = (SELECT idConfiguration FROM D_Configuration where configuration_name like '%Open JDK8 Metrics%' and
language_name LIKE CONCAT('%', @Project_Language, '%')); 

SET @Worst_Configuration  = (SELECT idConfiguration FROM D_Configuration where configuration_name like '%Tomcat Metrics%' and
language_name LIKE CONCAT('%', @Project_Language, '%')); 

# Consulta da Metrica LOC
SET @idLOC = (SELECT idMetric FROM D_Metric where metric_abbreviation='LOC'); 

# Consulta de Indicador de Qualidade de LOC na Configuracao Open JDK8 Metrics 
SET @qualityBestLOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='LOC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de LOC na Configuracao Tomcat Metrics
SET @qualityWorstLOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='LOC' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do LOC na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idLOC, @qualityBestLOC, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do LOC na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idLOC, @qualityWorstLOC, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica ACCM
SET @idACCM = (SELECT idMetric FROM D_Metric where metric_abbreviation='ACCM'); 

# Consulta de Indicador de Qualidade de ACCM na Configuracao Open JDK8 Metrics 
SET @qualityBestACCM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ACCM' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de ACCM na Configuracao Tomcat Metrics
SET @qualityWorstACCM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ACCM' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do ACCM na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idACCM, @qualityBestACCM, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do ACCM na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idACCM, @qualityWorstACCM, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica AMLOC
SET @idAMLOC = (SELECT idMetric FROM D_Metric where metric_abbreviation='AMLOC'); 

# Consulta de Indicador de Qualidade de AMLOC na Configuracao Open JDK8 Metrics 
SET @qualityBestAMLOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='AMLOC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de AMLOC na Configuracao Tomcat Metrics
SET @qualityWorstAMLOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='AMLOC' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do AMLOC na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idAMLOC, @qualityBestAMLOC, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do AMLOC na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idAMLOC, @qualityWorstAMLOC, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica ACC
SET @idACC = (SELECT idMetric FROM D_Metric where metric_abbreviation='ACC'); 

# Consulta de Indicador de Qualidade de ACC na Configuracao Open JDK8 Metrics 
SET @qualityBestACC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ACC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de ACC na Configuracao Tomcat Metrics
SET @qualityWorstACC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ACC' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do ACC na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idACC, @qualityBestACC, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do ACC na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idACC, @qualityWorstACC, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica ANPM
SET @idANPM = (SELECT idMetric FROM D_Metric where metric_abbreviation='ANPM'); 

# Consulta de Indicador de Qualidade de ANPM na Configuracao Open JDK8 Metrics 
SET @qualityBestANPM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ANPM' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de ANPM na Configuracao Tomcat Metrics
SET @qualityWorstANPM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='ANPM' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do ANPM na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idANPM, @qualityBestANPM, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do ANPM na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idANPM, @qualityWorstANPM, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica CBO
SET @idCBO = (SELECT idMetric FROM D_Metric where metric_abbreviation='CBO'); 

# Consulta de Indicador de Qualidade de CBO na Configuracao Open JDK8 Metrics 
SET @qualityBestCBO = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='CBO' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de CBO na Configuracao Tomcat Metrics
SET @qualityWorstCBO = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='CBO' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do CBO na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idCBO, @qualityBestCBO, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do CBO na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idCBO, @qualityWorstCBO, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica LCOM4
SET @idDIT = (SELECT idMetric FROM D_Metric where metric_abbreviation='DIT'); 

# Consulta de Indicador de Qualidade de DIT na Configuracao Open JDK8 Metrics 
SET @qualityBestDIT = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='DIT' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de DIT na Configuracao Tomcat Metrics
SET @qualityWorstDIT = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='DIT' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do DIT na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idDIT, @qualityBestDIT, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do DIT na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idDIT, @qualityWorstDIT, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica LCOM4
SET @idLCOM4 = (SELECT idMetric FROM D_Metric where metric_abbreviation='LCOM4'); 

# Consulta de Indicador de Qualidade de LCOM4 na Configuracao Open JDK8 Metrics 
SET @qualityBestLCOM4 = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='LCOM4' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de LCOM4 na Configuracao Tomcat Metrics
SET @qualityWorstLCOM4 = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='LCOM4' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do LCOM4 na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idLCOM4, @qualityBestLCOM4, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do LCOM4 na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idLCOM4, @qualityWorstLCOM4, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica NOC
SET @idNOC = (SELECT idMetric FROM D_Metric where metric_abbreviation='NOC'); 

# Consulta de Indicador de Qualidade de NOC na Configuracao Open JDK8 Metrics 
SET @qualityBestNOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NOC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de NOC na Configuracao Tomcat Metrics
SET @qualityWorstNOC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NOC' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do NOC na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNOC, @qualityBestNOC, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do NOC na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNOC, @qualityWorstNOC, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica NOM
SET @idNOM = (SELECT idMetric FROM D_Metric where metric_abbreviation='NOM'); 

# Consulta de Indicador de Qualidade de NOM na Configuracao Open JDK8 Metrics 
SET @qualityBestNOM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NOM' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de NOM na Configuracao Tomcat Metrics
SET @qualityWorstNOM = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NOM' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do NOM na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNOM, @qualityBestNOM, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do NOM na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNOM, @qualityWorstNOM, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica NPA
SET @idNPA = (SELECT idMetric FROM D_Metric where metric_abbreviation='NPA'); 

# Consulta de Indicador de Qualidade de NPA na Configuracao Open JDK8 Metrics 
SET @qualityBestNPA = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NPA' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de NPA na Configuracao Tomcat Metrics
SET @qualityWorstNPA = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='NPA' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do NPA na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNPA, @qualityBestNPA, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do NPA na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idNPA, @qualityWorstNPA, @Worst_Configuration, @idRelease, @idTime);

# Consulta da Metrica RFC
SET @idRFC = (SELECT idMetric FROM D_Metric where metric_abbreviation='RFC'); 

# Consulta de Indicador de Qualidade de RFC na Configuracao Open JDK8 Metrics 
SET @qualityBestRFC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='RFC' and ? <= max AND ? >= min and configuration_name like '%Open JDK8 Metrics%');

# Consulta de Indicador de Qualidade de RFC na Configuracao Tomcat Metrics
SET @qualityWorstRFC = (SELECT idQuality FROM Meta_Metric_Ranges
INNER JOIN D_Quality
ON Meta_Metric_Ranges.quality_index=D_Quality.quality_index where language_name =  @Project_Language 
and metric_name='RFC' and ? <= max AND ? >= min and configuration_name like '%Tomcat Metrics%');

# Inserindo o Fato do RFC na Configuracao Open JDK8 Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idRFC, @qualityBestRFC, @Best_Configuration, @idRelease, @idTime);

# Inserindo o Fato do RFC na Configuracao Tomcat Metrics ;
INSERT INTO `F_Project_Metric`
(`percentil_value`, `D_Project_idProject`, `D_Metric_idMetric`, `D_Quality_idQuality`, 
`D_Configuration_idConfiguration`, `D_Release_idRelease`,`D_Time_idTime`)
VALUES
(?, @idProject, @idRFC, @qualityWorstRFC, @Worst_Configuration, @idRelease, @idTime);