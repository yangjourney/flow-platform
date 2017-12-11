USE flow_api_db;

CREATE TABLE `sync` (
  `client_id` varchar(255) NOT NULL,
  `repo` varchar(100) NOT NULL,
  `sync_status` varchar(20) NOT NULL,
  `sync_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`client_id`,`repo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;