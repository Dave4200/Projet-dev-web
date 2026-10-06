-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 17 mai 2020 à 23:05
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gj01587m`
--

-- --------------------------------------------------------

--
-- Structure de la table `accede`
--

DROP TABLE IF EXISTS `accede`;
CREATE TABLE IF NOT EXISTS `accede` (
  `IdPseudo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `NomDocument` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `Createur` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `LectureSeul` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdPseudo`,`NomDocument`,`Createur`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `accede`
--

INSERT INTO `accede` (`IdPseudo`, `NomDocument`, `Createur`, `LectureSeul`) VALUES
('Jeremy', 'Doc1', 'Jeremy', 0),
('Jeremy', 'Document partager', 'Test', 0),
('Test', 'Document partager', 'Test', 0),
('Test', 'Document Test', 'Test', 0);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE IF NOT EXISTS `document` (
  `Nom` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `Createur` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `Texte` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL DEFAULT '',
  `Mdp` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `Public` tinyint(1) NOT NULL DEFAULT '0',
  `Proteger` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Nom`,`Createur`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`Nom`, `Createur`, `Texte`, `Mdp`, `Public`, `Proteger`) VALUES
('Doc1', 'Jeremy', '', '', 0, 0),
('Document partager', 'Test', 'Voici un document partager avec jeremy', '', 0, 0),
('Document Test', 'Test', 'Voici le premier document public ', '', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdPseudo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `NomDoc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `NomCreateur` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `texteMessage` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`Id`, `IdPseudo`, `NomDoc`, `NomCreateur`, `texteMessage`, `Date`) VALUES
(1, 'Test', 'Document Test', 'Test', 'Salut ', '2020-05-17 23:11:08'),
(2, 'Jeremy', 'Document partager', 'Test', 'Bonjour Test', '2020-05-17 23:13:58'),
(3, 'Test', 'Document partager', 'Test', 'Salut Jeremy', '2020-05-17 23:14:08'),
(4, 'Jeremy', 'Document Test', 'Test', 'Salut', '2020-05-17 23:32:49'),
(5, 'Jeremy', 'Doc1', 'Jeremy', 'Note pour plus tard', '2020-05-17 23:43:20');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IdPseudo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  `Mdp` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL,
  PRIMARY KEY (`IdPseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IdPseudo`, `Mdp`) VALUES
('Jeremy', '123'),
('Test', 'azerty');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
