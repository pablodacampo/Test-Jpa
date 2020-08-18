-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 18 août 2020 à 07:53
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestioneleves`
--
CREATE DATABASE IF NOT EXISTS `gestioneleves` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestioneleves`;

-- --------------------------------------------------------

--
-- Structure de la table `t_classe`
--

DROP TABLE IF EXISTS `t_classe`;
CREATE TABLE `t_classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prof` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `t_classe`
--

INSERT INTO `t_classe` (`id`, `nom`, `prof`) VALUES
(1, 'CP', 1),
(2, 'CE1', 2),
(3, 'CE2', 2),
(4, 'CM1', 3),
(5, 'CM2', 3);

-- --------------------------------------------------------

--
-- Structure de la table `t_eleve`
--

DROP TABLE IF EXISTS `t_eleve`;
CREATE TABLE `t_eleve` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `classe` int(11) NOT NULL,
  `date_naissance` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `adresse` varchar(250) DEFAULT NULL,
  `sexe` enum('HOMME','FEMME') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `t_eleve`
--

INSERT INTO `t_eleve` (`id`, `nom`, `prenom`, `classe`, `date_naissance`, `adresse`, `sexe`) VALUES
(1, 'Durand', 'Marie', 1, '2015-01-01 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(2, 'Alesi', 'Julie', 1, '2014-01-07 23:00:00', '72 av. Jean Dupont 75003 Paris', 'FEMME'),
(3, 'Martini', 'Carine', 5, '2008-01-16 23:00:00', '2 rue du Moulin 92230 Neullavy', 'FEMME'),
(4, 'Varola', 'Sophie', 5, '2009-01-20 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(5, 'Labiche', 'Lelou', 5, '2009-01-20 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(6, 'Dujardin', 'Anne', 5, '2008-02-02 23:00:00', '67 rue des Jardins 91800 Brunoy', 'FEMME'),
(7, 'Laventure', 'Martine', 5, '2009-02-14 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(8, 'Livradu', 'Alice', 5, '2008-02-17 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(9, 'Veronicci', 'Cerise', 5, '2008-02-29 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(10, 'Baladini', 'Mathilde', 5, '2009-03-11 23:00:00', '15 rue du Lac 75001 Paris', 'FEMME'),
(11, 'Michelet', 'Jean', 2, '2013-04-07 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(12, 'Dupond', 'Pierre', 2, '2013-04-08 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(13, 'Timberot', 'Martin', 3, '2011-04-13 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(14, 'Gravatas', 'Paul', 3, '2011-04-14 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(15, 'De La Grange', 'Luc', 5, '2008-04-15 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(16, 'Millot', 'Bertrand', 5, '2009-04-19 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(17, 'Herbert', 'Franck', 4, '2008-04-24 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(18, 'Dupontel', 'Sylvain', 4, '2008-05-01 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(19, 'Avati', 'Tom', 4, '2008-05-29 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(20, 'Lidar', 'Thierry', 2, '2013-06-01 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(21, 'Mo', 'Francis', 2, '2013-06-02 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(22, 'Obino', 'Alex', 2, '2013-06-07 22:00:00', '2 rue Jean Paul 92340 Vallodo', 'HOMME'),
(23, 'Martin', 'Julien', 3, '2010-06-08 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(24, 'Balado', 'Arnaud', 3, '2011-06-12 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(25, 'Falafav', 'Cedric', 3, '2010-06-16 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(26, 'Dominicci', 'Adrien', 4, '2009-06-24 22:00:00', '32 rue des Fleurs 75018 Paris', 'HOMME'),
(27, 'Julives', 'Fabien', 4, '2008-06-29 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(28, 'Loribo', 'Paul', 4, '2008-07-03 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(29, 'Allen', 'Pierre', 4, '2008-07-13 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(30, 'Renaldino', 'Yann', 4, '2008-07-14 22:00:00', '43 rue du Temps 75015 Paris', 'HOMME'),
(31, 'Margalev', 'Vincent', 4, '2008-07-30 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(32, 'Roidunor', 'Denis', 4, '2008-07-31 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(33, 'Tong', 'Hing', 4, '2008-08-01 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(34, 'Du Chemin', 'Ludovic', 3, '2009-08-11 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(35, 'Denali', 'Daniel', 3, '2010-08-21 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(36, 'Maccimo', 'Marcel', 3, '2010-08-22 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(37, 'Formi', 'Alexandre', 3, '2010-09-02 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(38, 'Malengo', 'Tom', 3, '2010-10-03 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(39, 'Legrand', 'Jean-Batiste', 3, '2010-10-04 22:00:00', '14 rue des Souris 93100 Saint-Denis', 'HOMME'),
(40, 'Lebeau', 'Olivier', 3, '2010-10-06 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(41, 'Hariford', 'John', 2, '2010-10-07 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(42, 'Lessetaire', 'Hanibal', 2, '2012-10-11 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(43, 'Dupont', 'Albert', 2, '2011-10-12 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(44, 'Burmi', 'Nestor', 2, '2012-10-19 22:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(45, 'Foredecafay', 'Felix', 2, '2012-10-20 22:00:00', '23 av. du Ciel 75014 Paris', 'HOMME'),
(46, 'Lepetit', 'Nicolas', 2, '2011-11-03 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(47, 'Daudet', 'Alphonse', 2, '2012-11-17 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(48, 'Valegin', 'Jean', 1, '2014-11-27 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(49, 'Eto', 'Gabin', 1, '2015-11-17 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(50, 'Fivolini', 'Kevin', 1, '2015-12-05 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(51, 'Laferme', 'Martin', 1, '2015-12-06 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(52, 'Dupuis', 'Vincent', 1, '2015-12-14 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME'),
(53, 'Lagrange', 'Alexandre', 1, '2014-12-27 23:00:00', '15 rue du Lac 75001 Paris', 'HOMME');

-- --------------------------------------------------------

--
-- Structure de la table `t_matiere`
--

DROP TABLE IF EXISTS `t_matiere`;
CREATE TABLE `t_matiere` (
  `idmatiere` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_notes`
--

DROP TABLE IF EXISTS `t_notes`;
CREATE TABLE `t_notes` (
  `idnotes` int(11) NOT NULL,
  `date_saisie` date NOT NULL,
  `ideleve` int(11) NOT NULL,
  `idclasse` int(11) NOT NULL,
  `idmatiere` int(11) NOT NULL,
  `idprof` int(11) NOT NULL,
  `idtrimestre` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `avis` text NOT NULL,
  `avancement` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `t_prof`
--

DROP TABLE IF EXISTS `t_prof`;
CREATE TABLE `t_prof` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `date_naissance` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `adresse` varchar(250) DEFAULT NULL,
  `sexe` enum('HOMME','FEMME') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `t_prof`
--

INSERT INTO `t_prof` (`id`, `nom`, `prenom`, `date_naissance`, `adresse`, `sexe`) VALUES
(1, 'GERMAIN', 'Christophe', '1971-01-01 23:00:00', '15 rue du printemps 59000 LILLE', 'HOMME'),
(2, 'LOUREIRO', 'Julie', '1982-01-07 23:00:00', '72 av. Matigon 75003 Paris', 'FEMME'),
(3, 'SIMON', 'Jean', '1992-01-16 23:00:00', '2 rue du Moulin 92230 Neullavy', 'HOMME');

-- --------------------------------------------------------

--
-- Structure de la table `t_trimestre`
--

DROP TABLE IF EXISTS `t_trimestre`;
CREATE TABLE `t_trimestre` (
  `idtrimestre` int(11) NOT NULL,
  `nom` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `t_classe`
--
ALTER TABLE `t_classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_prof` (`prof`);

--
-- Index pour la table `t_eleve`
--
ALTER TABLE `t_eleve`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_classe` (`classe`);

--
-- Index pour la table `t_matiere`
--
ALTER TABLE `t_matiere`
  ADD PRIMARY KEY (`idmatiere`);

--
-- Index pour la table `t_notes`
--
ALTER TABLE `t_notes`
  ADD PRIMARY KEY (`idnotes`),
  ADD KEY `note_eleve` (`ideleve`),
  ADD KEY `note_classe` (`idclasse`),
  ADD KEY `note_matiere` (`idmatiere`),
  ADD KEY `note_prof` (`idprof`),
  ADD KEY `note_trimestre` (`idtrimestre`);

--
-- Index pour la table `t_prof`
--
ALTER TABLE `t_prof`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `t_trimestre`
--
ALTER TABLE `t_trimestre`
  ADD PRIMARY KEY (`idtrimestre`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `t_classe`
--
ALTER TABLE `t_classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `t_eleve`
--
ALTER TABLE `t_eleve`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT pour la table `t_matiere`
--
ALTER TABLE `t_matiere`
  MODIFY `idmatiere` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `t_notes`
--
ALTER TABLE `t_notes`
  MODIFY `idnotes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `t_prof`
--
ALTER TABLE `t_prof`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `t_trimestre`
--
ALTER TABLE `t_trimestre`
  MODIFY `idtrimestre` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `t_classe`
--
ALTER TABLE `t_classe`
  ADD CONSTRAINT `fk_prof` FOREIGN KEY (`prof`) REFERENCES `t_prof` (`id`);

--
-- Contraintes pour la table `t_eleve`
--
ALTER TABLE `t_eleve`
  ADD CONSTRAINT `fk_classe` FOREIGN KEY (`classe`) REFERENCES `t_classe` (`id`);

--
-- Contraintes pour la table `t_notes`
--
ALTER TABLE `t_notes`
  ADD CONSTRAINT `note_classe` FOREIGN KEY (`idclasse`) REFERENCES `t_classe` (`id`),
  ADD CONSTRAINT `note_eleve` FOREIGN KEY (`ideleve`) REFERENCES `t_eleve` (`id`),
  ADD CONSTRAINT `note_matiere` FOREIGN KEY (`idmatiere`) REFERENCES `t_matiere` (`idmatiere`),
  ADD CONSTRAINT `note_prof` FOREIGN KEY (`idprof`) REFERENCES `t_prof` (`id`),
  ADD CONSTRAINT `note_trimestre` FOREIGN KEY (`idtrimestre`) REFERENCES `t_trimestre` (`idtrimestre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
