CREATE TABLE IF NOT EXISTS screenshotter_user (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL
);

INSERT IGNORE INTO screenshotter_user (user_name) VALUES ('richard');
INSERT IGNORE INTO screenshotter_user (user_name) VALUES ('ron');
INSERT IGNORE INTO screenshotter_user (user_name) VALUES ('ryan');
