-- #########################################################
START TRANSACTION;
-- #########################################################
-- Database: 'crud_java'
-- #########################################################
CREATE TABLE `cliente` (
  `id`    int(6)      NOT NULL,
  `nome`  varchar(60) NOT NULL,
  `idade` int(3)      NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- #########################################################
INSERT INTO `cliente` (`id`, `nome`, `idade`) VALUES
  (1, 'Monica', 38),
  (2, 'Carlos ', 25),
  (3, 'Pedro', 63);
-- #########################################################
ALTER TABLE `cliente` ADD PRIMARY KEY (`id`);
-- #########################################################
ALTER TABLE `cliente`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;
-- #########################################################