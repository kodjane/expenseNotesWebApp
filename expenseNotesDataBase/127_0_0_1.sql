-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 15 jan. 2018 à 13:03
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `expensenote`
--
CREATE DATABASE IF NOT EXISTS `expensenote` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `expensenote`;

-- --------------------------------------------------------

--
-- Structure de la table `expense`
--

CREATE TABLE `expense` (
  `id` bigint(20) NOT NULL,
  `approval_date` datetime DEFAULT NULL,
  `approval_status` varchar(50) DEFAULT NULL,
  `submission_date` datetime NOT NULL,
  `total` double NOT NULL,
  `approver` bigint(20) DEFAULT NULL,
  `submitter` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `expense`
--

INSERT INTO `expense` (`id`, `approval_date`, `approval_status`, `submission_date`, `total`, `approver`, `submitter`) VALUES
(1, '2018-01-14 15:03:12', 'Yes', '2018-01-14 14:52:36', 28.169, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `expense_line`
--

CREATE TABLE `expense_line` (
  `id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `currency` varchar(50) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `expense` bigint(20) DEFAULT NULL,
  `expense_type` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `expense_line`
--

INSERT INTO `expense_line` (`id`, `amount`, `currency`, `date`, `expense`, `expense_type`) VALUES
(1, 28.169, 'USD', '2017/02/18', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `expense_type`
--

CREATE TABLE `expense_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `expense_type`
--

INSERT INTO `expense_type` (`id`, `name`) VALUES
(1, 'Transport'),
(2, 'Food'),
(3, 'Hotel'),
(4, 'Health Care'),
(5, 'Medical Insurance');

-- --------------------------------------------------------

--
-- Structure de la table `people`
--

CREATE TABLE `people` (
  `PEOPLE_ID` bigint(20) NOT NULL,
  `ABSENCEALLOWANCESTARTDATE` datetime DEFAULT NULL,
  `ABSENTEEISMSCHEME` varchar(50) DEFAULT NULL,
  `ADDRESS1` varchar(50) DEFAULT NULL,
  `ADDRESS2` varchar(50) DEFAULT NULL,
  `ADDRESS3` varchar(50) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `AGECALCULATED` varchar(50) DEFAULT NULL,
  `ALIENREGISTRATIONCARD` char(1) DEFAULT NULL,
  `ANNIVERSARYDOJ` datetime DEFAULT NULL,
  `APPRAISALUPDATE` char(1) DEFAULT NULL,
  `ATTACHEDCRIMINALRECORD` char(1) DEFAULT NULL,
  `ATTACHEDCV` char(1) DEFAULT NULL,
  `ATTACHEDID` char(1) DEFAULT NULL,
  `ATTACHEDPICTURE` char(1) DEFAULT NULL,
  `BEBONOTES` longtext,
  `BEBOPROFILE` varchar(20) DEFAULT NULL,
  `BENATIONALREGISTERID` varchar(11) DEFAULT NULL,
  `BESOCIALSECURITYOVERSEAS` varchar(15) DEFAULT NULL,
  `BIRTHCOUNTRY` varchar(50) DEFAULT NULL,
  `BIRTHPLACE` varchar(50) DEFAULT NULL,
  `BLACKBERRY` char(1) DEFAULT NULL,
  `BLOCKEDBYSHU` char(1) DEFAULT NULL,
  `CANDIDATEFLAG` char(1) DEFAULT NULL,
  `CARPARKPASS` char(1) DEFAULT NULL,
  `CARSELECTED` varchar(50) DEFAULT NULL,
  `CERTIFICATEOFBIRTHABROAD` char(1) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `COACHFLAG` char(1) DEFAULT NULL,
  `CONTRACTINGSECTION` varchar(50) DEFAULT NULL,
  `CONTRACTORFLAG` char(1) DEFAULT NULL,
  `CONTRACTSTATUS` varchar(20) DEFAULT NULL,
  `COUNT` decimal(19,2) DEFAULT NULL,
  `COUNTRY` varchar(50) DEFAULT NULL,
  `COUNTY` varchar(50) DEFAULT NULL,
  `COVERINGABOUT` longtext,
  `CPD` varchar(50) DEFAULT NULL,
  `CREATEDBY` longtext,
  `CURRENTBIRTHDAY` datetime DEFAULT NULL,
  `DATEACCESSMENTCENTER` datetime DEFAULT NULL,
  `DATECREATED` datetime DEFAULT NULL,
  `DATEJOINEDOVERSEASOFFICE` datetime DEFAULT NULL,
  `DATELASTMODIFIED` datetime DEFAULT NULL,
  `DATEOFBIRTH` datetime DEFAULT NULL,
  `DATEOFDEATH` datetime DEFAULT NULL,
  `DATEOFJOIN` datetime DEFAULT NULL,
  `DATEOFLEAVING` datetime DEFAULT NULL,
  `DATEOFRETIREMENT` datetime DEFAULT NULL,
  `DATERECRUITED` datetime DEFAULT NULL,
  `DATEWHEN60` datetime DEFAULT NULL,
  `DAYOFBIRTHDAY` int(11) DEFAULT NULL,
  `DBPEOPLENUMBER` int(11) DEFAULT NULL,
  `DEL` char(1) DEFAULT NULL,
  `DIRECTOR` char(1) DEFAULT NULL,
  `DIRECTORTAXWEEK` int(11) DEFAULT NULL,
  `DISABILITYREGNUMBER` varchar(20) DEFAULT NULL,
  `DISABLED` char(1) DEFAULT NULL,
  `DOJPLUS6MONTHS` datetime DEFAULT NULL,
  `DOVETAILNUMBER` varchar(20) DEFAULT NULL,
  `DRIVERSLICENCE` char(1) DEFAULT NULL,
  `DRIVINGLICENCE` varchar(50) DEFAULT NULL,
  `DRIVINGLICENCENO` varchar(20) DEFAULT NULL,
  `EEOCATEGORY` varchar(50) DEFAULT NULL,
  `EEOCODE` varchar(20) DEFAULT NULL,
  `EMAILPRIMARY` varchar(255) DEFAULT NULL,
  `EMAILSECONDARY` varchar(255) DEFAULT NULL,
  `EMAILWORKFLOW` varchar(255) DEFAULT NULL,
  `EMPLOYEEFLAG` char(1) DEFAULT NULL,
  `EMPLOYEESTATUS` varchar(7) DEFAULT NULL,
  `EMPLOYEETYPE` varchar(50) DEFAULT NULL,
  `EMPLOYMENTAUTHENTICATION` char(1) DEFAULT NULL,
  `ENDOFPROBATIONCALC` datetime DEFAULT NULL,
  `ENDOFPROBATIONDATE` datetime DEFAULT NULL,
  `ETHNICITY` varchar(50) DEFAULT NULL,
  `EXPECTEDRETIREMENTDATE` datetime DEFAULT NULL,
  `FATHERSDATEOFBIRTH` datetime DEFAULT NULL,
  `FATHERSFIRSTNAME` varchar(50) DEFAULT NULL,
  `FATHERSLASTNAME` varchar(50) DEFAULT NULL,
  `FIRSTNAME` varchar(30) DEFAULT NULL,
  `FLAGREPORTSTO` char(1) DEFAULT NULL,
  `FLEETSELECTION` varchar(50) DEFAULT NULL,
  `FORMALNAME` varchar(112) DEFAULT NULL,
  `FULLNAME` varchar(61) DEFAULT NULL,
  `GENDER` varchar(50) DEFAULT NULL,
  `HINDIFIRSTNAME` varchar(20) DEFAULT NULL,
  `HINDILASTNAME` varchar(20) DEFAULT NULL,
  `HOMETELEPHONE` varchar(50) DEFAULT NULL,
  `I9RENEWALDATE` datetime DEFAULT NULL,
  `IDCARD` char(1) DEFAULT NULL,
  `IDCARDNUM` varchar(50) DEFAULT NULL,
  `INITIALS` varchar(10) DEFAULT NULL,
  `Job` varchar(100) DEFAULT NULL,
  `KNOWNAS` varchar(30) DEFAULT NULL,
  `LAPTOP` char(1) DEFAULT NULL,
  `LASTDAYINOFFICE` datetime DEFAULT NULL,
  `LASTMODIFIEDBY` longtext,
  `LASTNAME` varchar(30) DEFAULT NULL,
  `LAWSOCIETYADMISSIONDATE` datetime DEFAULT NULL,
  `LAWSOCIETYMEMBERSHIPNUMBER` varchar(20) DEFAULT NULL,
  `LAWSOCIETYSTATUS` varchar(50) DEFAULT NULL,
  `LEAVINGDETAILS` longtext,
  `LEGALLANGUAGE` varchar(50) DEFAULT NULL,
  `LENGTHOFSERVICE` int(11) DEFAULT NULL,
  `LENGTHOFSERVICECUSTOM` varchar(50) DEFAULT NULL,
  `LINKEDINNOTES` longtext,
  `LOCATION` varchar(50) DEFAULT NULL,
  `MAIDENNAME` varchar(30) DEFAULT NULL,
  `MAILBOX` varchar(10) DEFAULT NULL,
  `MAINFUNCTIONABOUT` longtext,
  `MARITALSTATUS` varchar(50) DEFAULT NULL,
  `MARITALSTATUSVALUE` varchar(50) DEFAULT NULL,
  `MARRIAGEGIFT` char(1) DEFAULT NULL,
  `MENTORFLAG` char(1) DEFAULT NULL,
  `MGRDELEGATOR` varchar(50) DEFAULT NULL,
  `MGRDELEGATORENDDATE` datetime DEFAULT NULL,
  `MGRDELEGATORSTARTDATE` datetime DEFAULT NULL,
  `MIDDLENAMES` varchar(50) DEFAULT NULL,
  `MISSIONTAG` varchar(20) DEFAULT NULL,
  `MOBILE` char(1) DEFAULT NULL,
  `MOBILETELEPHONE` varchar(50) DEFAULT NULL,
  `MOBILITY` varchar(50) DEFAULT NULL,
  `MOBILITYAREAPREFERENCE1` varchar(50) DEFAULT NULL,
  `MOBILITYAREAPREFERENCE2` varchar(50) DEFAULT NULL,
  `MOBILITYAREAPREFERENCE3` varchar(50) DEFAULT NULL,
  `MOBILITYNOTES` longtext,
  `MOBILITYREGIONPREFERENCE1` varchar(50) DEFAULT NULL,
  `MOBILITYREGIONPREFERENCE2` varchar(50) DEFAULT NULL,
  `MOBILITYREGIONPREFERENCE3` varchar(50) DEFAULT NULL,
  `MONTHOFBIRTHDAY` int(11) DEFAULT NULL,
  `MOTHERSDATEOFBIRTH` datetime DEFAULT NULL,
  `MOTHERSFIRSTNAME` varchar(50) DEFAULT NULL,
  `MOTHERSLASTNAME` varchar(50) DEFAULT NULL,
  `MSFEMAIL` varchar(255) DEFAULT NULL,
  `MSFLANGUAGE` varchar(50) DEFAULT NULL,
  `MYSPACENOTES` longtext,
  `NAMEPLUSREFNO` varchar(74) DEFAULT NULL,
  `NATIONALITY` varchar(50) DEFAULT NULL,
  `NATIONALSTAFF` char(1) DEFAULT NULL,
  `NATIVEAMERICANTRIBALDOCUMENT` char(1) DEFAULT NULL,
  `NEXTBIRTHDAY` datetime DEFAULT NULL,
  `NEXTBIRTHDAYPLUS1YEAR` datetime DEFAULT NULL,
  `NINUMBER` varchar(20) DEFAULT NULL,
  `NIRATE` varchar(50) DEFAULT NULL,
  `NOTESLAW` longtext,
  `NOTICEPERIOD` varchar(50) DEFAULT NULL,
  `NUMBEROFCHILDREN` int(11) DEFAULT NULL,
  `OTHERROLESABOUT` longtext,
  `OUTCOMEOFPROBATION` varchar(50) DEFAULT NULL,
  `PAGER` varchar(20) DEFAULT NULL,
  `PAYMENTMETHOD` varchar(50) DEFAULT NULL,
  `PAYRANGES` varchar(50) DEFAULT NULL,
  `PAYROLL` varchar(50) DEFAULT NULL,
  `PAYROLLNUMBER` varchar(20) DEFAULT NULL,
  `PERMANENTRESIDENCECARD` char(1) DEFAULT NULL,
  `PERSONALNOTES` varchar(50) DEFAULT NULL,
  `PHOTO` longblob,
  `PMISELECTION` varchar(50) DEFAULT NULL,
  `POOLFLAG` char(1) DEFAULT NULL,
  `POSTCODE` varchar(10) DEFAULT NULL,
  `PREVIOUSEMPLOYEEREFERENCE` varchar(20) DEFAULT NULL,
  `PREVIOUSLASTNAME` varchar(30) DEFAULT NULL,
  `PROBATIONDATECALCULATED` datetime DEFAULT NULL,
  `PROBATIONEXTENDEDDATE` datetime DEFAULT NULL,
  `PROBATIONNOTES` longtext,
  `PSYFPOFOFFICE` varchar(50) DEFAULT NULL,
  `PSYFPOFSECTION` varchar(50) DEFAULT NULL,
  `PUBLICHOLIDAYSCHEME` varchar(50) DEFAULT NULL,
  `QLTTBYWHOM` varchar(50) DEFAULT NULL,
  `QLTTCERTIFICATESEEN` char(1) DEFAULT NULL,
  `QLTTCOMPLETED` char(1) DEFAULT NULL,
  `QLTTDATE` datetime DEFAULT NULL,
  `REASONFORLEAVING` varchar(50) DEFAULT NULL,
  `RECRUITEDAS` varchar(50) DEFAULT NULL,
  `RECRUITEDBY` varchar(50) DEFAULT NULL,
  `RECRUITEROFOFFICE` varchar(50) DEFAULT NULL,
  `RECRUITEROFSECTION` varchar(50) DEFAULT NULL,
  `RECRUITINGDOCSCERTIFMEDICAL` char(1) DEFAULT NULL,
  `RECRUITINGDOCSDEPENDANTS` char(1) DEFAULT NULL,
  `RECRUITINGDOCSEDUCATION` char(1) DEFAULT NULL,
  `RECRUITINGDOCSMEDICAL` char(1) DEFAULT NULL,
  `RECRUITINGDOCSPASSPORT` char(1) DEFAULT NULL,
  `RECRUITINGDOCSPERSONAL` char(1) DEFAULT NULL,
  `RECRUITINGDOCSPREVEMPLOYMENT` char(1) DEFAULT NULL,
  `RECRUITINGOFFICE` varchar(50) DEFAULT NULL,
  `RECRUITINGSECTION` varchar(50) DEFAULT NULL,
  `REFERENCEHERO` int(11) DEFAULT NULL,
  `REFERENCENUMBER` varchar(10) DEFAULT NULL,
  `RELIGION` varchar(50) DEFAULT NULL,
  `REPORTSTO` varchar(50) DEFAULT NULL,
  `REPORTSTOBEFOREDELEGATION` varchar(50) DEFAULT NULL,
  `REPORTSTOFIRSTNAME` varchar(30) DEFAULT NULL,
  `REPORTSTOFULLNAME` varchar(61) DEFAULT NULL,
  `REPORTSTOLASTNAME` varchar(30) DEFAULT NULL,
  `RETIREMENTDATE` datetime DEFAULT NULL,
  `REVIEW` varchar(30) DEFAULT NULL,
  `RISKOFLEAVING` varchar(50) DEFAULT NULL,
  `RPAPPROACHINGRETIREMENT` varchar(3) DEFAULT NULL,
  `SCANNEDW4DOCUMENT` char(1) DEFAULT NULL,
  `SCNDADDRESS1` varchar(50) DEFAULT NULL,
  `SCNDADDRESS2` varchar(50) DEFAULT NULL,
  `SCNDADDRESS3` varchar(50) DEFAULT NULL,
  `SCNDCITY` varchar(50) DEFAULT NULL,
  `SCNDCOUNTRY` varchar(50) DEFAULT NULL,
  `SCNDMAILBOX` varchar(10) DEFAULT NULL,
  `SCNDPOSTCODE` varchar(10) DEFAULT NULL,
  `SCNDSTREETNUMBER` varchar(10) DEFAULT NULL,
  `SCONNO` varchar(20) DEFAULT NULL,
  `SECONDNATIONALITY` varchar(50) DEFAULT NULL,
  `SECRETARY` varchar(50) DEFAULT NULL,
  `SENDAPPRAISALNOTIFICATION` datetime DEFAULT NULL,
  `SENDBIRTHDAYREMINDER` datetime DEFAULT NULL,
  `SEXUALORIENTATION` varchar(50) DEFAULT NULL,
  `SICKALLOW` varchar(50) DEFAULT NULL,
  `SKYPE` varchar(50) DEFAULT NULL,
  `SPINALPOINT` longtext,
  `SSDATE` varchar(50) DEFAULT NULL,
  `SSP` char(1) DEFAULT NULL,
  `STARTDATE` datetime DEFAULT NULL,
  `STARTTYPE` varchar(50) DEFAULT NULL,
  `STATUS` varchar(50) DEFAULT NULL,
  `STREETNUMBER` varchar(10) DEFAULT NULL,
  `STUDYLEVEL` varchar(50) DEFAULT NULL,
  `SUBMITTINGUSER` varchar(50) DEFAULT NULL,
  `SUPERVISOR` varchar(50) DEFAULT NULL,
  `SUPPLIER` char(1) DEFAULT NULL,
  `SWIPECARD` char(1) DEFAULT NULL,
  `TAXCODE` varchar(10) DEFAULT NULL,
  `TEXTDATEOFBIRTH` varchar(92) DEFAULT NULL,
  `TEXTDATEOFJOIN` varchar(92) DEFAULT NULL,
  `TEXTDATEOFLEAVING` varchar(92) DEFAULT NULL,
  `TEXTPAYMENTMETHOD` varchar(50) DEFAULT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `TRAINERFLAG` char(1) DEFAULT NULL,
  `UpChain` longtext,
  `up_chain` longtext,
  `USAC` char(1) DEFAULT NULL,
  `USCITIZENIDCARD` char(1) DEFAULT NULL,
  `USERBYADMIN` char(1) DEFAULT NULL,
  `USERBYPOOLMANAGER` char(1) DEFAULT NULL,
  `USERBYRECRUITER` char(1) DEFAULT NULL,
  `USERDATECREATED` datetime DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `USPASSPORT` char(1) DEFAULT NULL,
  `USSOCIALSECURITYCARD` char(1) DEFAULT NULL,
  `VACANCY` varchar(50) DEFAULT NULL,
  `VOLUNTEER` char(1) DEFAULT NULL,
  `W4STATUS` varchar(50) DEFAULT NULL,
  `WK1MT1` char(1) DEFAULT NULL,
  `WORKEXT` varchar(20) DEFAULT NULL,
  `WORKTELEPHONE` varchar(20) DEFAULT NULL,
  `WTDDATE` datetime DEFAULT NULL,
  `WTDOPTOUT` char(1) DEFAULT NULL,
  `YEARCURRENT` int(11) DEFAULT NULL,
  `YEARPICKLIST` varchar(50) DEFAULT NULL,
  `YEARSOFSERVICE` int(11) DEFAULT NULL,
  `ZROOMNUMBER` varchar(35) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`userid`, `email`, `enabled`, `password`, `username`) VALUES
(1, 'kodjane09@hotmail.com', 1, '$2a$10$LItRloyVRYWUlqBR2xtl5elRdPHEbNc2yba6KUcSvaizyptBxQKwC', 'kodjane'),
(2, 'user@gmail.com', 1, '$2a$10$ANbYyrJy3XtaGkFhSM6.M.zHRWb.KHRKfsClt1D4EyjPU0PbETF1e', 'user');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `role`, `userid`) VALUES
(1, 'ROLE_MANAGER', 1),
(2, 'ROLE_USER', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2ber9mp57kqwrcqyny2fv5mgv` (`approver`),
  ADD KEY `FKl49atyxo88yt2ihw17jmkto83` (`submitter`);

--
-- Index pour la table `expense_line`
--
ALTER TABLE `expense_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKesk7p7t8o3s1p18i9nmter6ri` (`expense`),
  ADD KEY `FKb6bp78eh28xoo6qi5ls5duquk` (`expense_type`);

--
-- Index pour la table `expense_type`
--
ALTER TABLE `expense_type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`PEOPLE_ID`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `expense`
--
ALTER TABLE `expense`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `expense_line`
--
ALTER TABLE `expense_line`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `expense_type`
--
ALTER TABLE `expense_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `people`
--
ALTER TABLE `people`
  MODIFY `PEOPLE_ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `userid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
