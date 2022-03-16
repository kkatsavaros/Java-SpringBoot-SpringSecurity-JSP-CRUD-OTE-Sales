-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 16 Μαρ 2022 στις 07:05:42
-- Έκδοση διακομιστή: 8.0.17
-- Έκδοση PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `iyjsvkfs_otesales2`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `stathero` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kinito` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `perioxi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `eidospolisis` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `notes` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mylead` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mydate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `author`
--

INSERT INTO `author` (`id`, `name`, `stathero`, `kinito`, `perioxi`, `eidospolisis`, `notes`, `mylead`, `mydate`) VALUES
(13, 'Αναστασία Παρχαρίδου', '2510240975', '6945509704', 'Καβάλα', '50 to 100', 'Γιάννης Holder - Αθηνών 49 - 65404 - Αγιος Λουκάς', 'ΜΗ ΠΩΛΗΣΗ - ΔΕΝ ΕΝΔΙΑΦΕΡΕΤΑΙ', '2021-04-01'),
(14, ' Γαβριηλίδης Μιχαήλ', '2510240755', '6970626444', 'Καβάλα', 'FTTH', 'Νατάσσα Holder - Ζαλόγγου 34 - 65404 - DSLAM 31688 - Βύρωνας', 'ΠΩΛΗΣΗ', '2021-04-01'),
(15, 'Μαργαρίτης Χαράλαμπος', '2510242065', '6970626444', 'Καβάλα', 'FTTH', 'Iωάννα Holder -Μαργαρίτης Χαράλαμπος- ΑΦΜ: 10246769 - Σοφοκλή Βενιζέλου 52 - Κηπούπολη', 'ΚΑΤΑΧΩΡΗΣΗ', '2021-04-01'),
(16, 'Λεονταράκης Κωνσταντίνος ', '-', '6934900124', 'Θάσος', 'Νέα Σύνδεση', '25930 31331 - Σκάλα Καλλιράχης', 'ΠΩΛΗΣΗ', '2021-04-01'),
(190, 'vvv', 'vvv', 'vvvv', 'Χρυσούπολη', 'Νέα Σύνδεση', 'vvvvv', 'ΜΗ ΠΩΛΗΣΗ - ΠΟΛΛΑΠΛΑ SR', '2022-01-27'),
(191, 'll2', 'llll2', 'lll2', 'Ν. Ηρακλείτσα', 'TP LINK POWERLINE 4226', 'lll2', 'ΜΗ ΠΩΛΗΣΗ - 13888', '2022-01-19');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `myuser`
--

CREATE TABLE `myuser` (
  `uid` int(11) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(68) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `myuser`
--

INSERT INTO `myuser` (`uid`, `username`, `password`, `fname`, `lname`, `email`) VALUES
(1, 'tasos', '$2a$10$sM9hhU4MgewBGpFC69CUK.i.TVEI.UxUj4BScrzTEOpIztx1rjRhS', 'Anastasios', 'Lelakis', 'email@hotmail.com'),
(2, 'dfsadfs', '$2a$10$OITlSxt0M/.WUEWpnv.9hezGv.qwWPfYUoICscVj.d0bAnecLbHDa', 'rt', 'wertwert', 'rtrew@dfdasf'),
(3, 'panagiotis', '$2a$10$D7UDlAb6qqe/x54SEXNCzOv9FTsqWJ5.aRbgQsyKGmKl9F4CwfQLK', 'Panagiotis', 'Katsavaros', 'pkatsavaros@gmail.com'),
(4, 'dimi', '$2a$10$YMBukbB7HNfrMhNlxTeKKeRblj.MlXjmotuBw1W3fX1jpGPR7c30q', 'Dimitris', 'Kalivas', 'fsdaf@dsaf'),
(5, 'dsf', '$2a$10$wrEjqvdjWc0P3Hokv8qgBOBT8d8KcTtDUfrGDlFxZR0K/3yxkfaUi', 'ff', 'ff', 'ffff@ffff.gr'),
(6, 'kavala', '$2a$10$G1QCWZ8os/EE.MZhzKT9jurirHbeJ14mOlMHm5dOIw3VDsDCi/5rK', 'kavala', 'kavala', 'kavala@gmail.com'),
(7, 'ddd', '$2a$10$tL/jWtA7EuzKGX3pw5XAruLDft7hvAM6FH5UHLRbDcFPrCjK0Bi5q', 'fsd', 'dfd', 'kkatsavaros@gmail.com'),
(8, 'sss', '$2a$10$UzxKRdWDRWKRLIIdJ1OXVupDiVw.4uQ75Ftxk08RH2WLf/W.E/ai6', 'sss', 'ssss', 'ss@sss.gr'),
(9, 'sd', '$2a$10$jQSGjqEUEcOnZEhHkFiTNOJ3wdOJxoW3OyNCCAAf9JIxlFmDrwwTS', 'dd', 'ddd', 'kavala@gmail.com'),
(10, 'fff', '$2a$10$BqevygiwFHEMyvgYPGxyPuscc/9fW9/BMBJxxkfDeh5wYHeMUez7W', 'ff', 'ff', 'ffff@ffff.gr'),
(11, 'μμμ', '$2a$10$rC8C6Wuu10rOOM604QkrOOtBxJ/vG58W43Pfdg.QqX5j3bzro5Kh.', 'μμμ', 'μμμ', 'kavala@gmail.com'),
(12, 'papas', '$2a$10$WY8H5d.Or85Q.S5KtPsCEui6/PVsSm4mDsOMEPCv321kZKpZKsXoy', 'papas', 'papas', 'papas@papas.gr');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `role`
--

CREATE TABLE `role` (
  `rid` int(11) NOT NULL,
  `rname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `role`
--

INSERT INTO `role` (`rid`, `rname`) VALUES
(1, 'ROLE_ADMIN'),
(3, 'ROLE_TEACHER'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `user_role`
--

CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `user_role`
--

INSERT INTO `user_role` (`uid`, `rid`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `myuser`
--
ALTER TABLE `myuser`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `user_unique_username` (`username`);

--
-- Ευρετήρια για πίνακα `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rid`),
  ADD UNIQUE KEY `role_unique_rname` (`rname`);

--
-- Ευρετήρια για πίνακα `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`uid`,`rid`),
  ADD KEY `user_role_rif_fk` (`rid`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=192;

--
-- AUTO_INCREMENT για πίνακα `myuser`
--
ALTER TABLE `myuser`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT για πίνακα `role`
--
ALTER TABLE `role`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_rif_fk` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  ADD CONSTRAINT `user_role_uid_fk` FOREIGN KEY (`uid`) REFERENCES `myuser` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
