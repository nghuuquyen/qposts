INSERT INTO category(id, name, description)
VALUES ("C01", "Khoa học công nghệ", "Các bài viết hoặc chia sẽ chung về khoa học công nghệ");

INSERT INTO category(id, name, description)
VALUES ("C02", "Công nghệ mới", "Cập nhật công nghệ mới");

INSERT INTO category(id, name, description)
VALUES ("C03", "Chia sẽ kinh nghiệm", "Chia sẽ kinh nghiệm làm việc");

INSERT INTO category(id, name, description)
VALUES ("C04", "Góc nhìn cuộc sống", "Các bài viết với chủ đề về cuộc sống");

INSERT INTO post(id,name,description,content, category_id) 
VALUES ("P01", "Bài viết số 2", "Mô tả bài viết số 1", "Nội dung bài viết", "C01");

INSERT INTO post(id,name,description,content, category_id) 
VALUES ("P02", "Bài viết số 2", "Mô tả bài viết số 2", "Nội dung bài viết", "C02");

INSERT INTO post(id,name,description,content, category_id) 
VALUES ("P03", "Bài viết số 3", "Mô tả bài viết số 3", "Nội dung bài viết", "C04");

INSERT INTO post(id,name,description,content, category_id) 
VALUES ("P04", "Bài viết số 4", "Mô tả bài viết số 4", "Nội dung bài viết", "C03");

INSERT INTO post(id,name,description,content, category_id) 
VALUES ("P05", "Bài viết số 5", "Mô tả bài viết số 5", "Nội dung bài viết", "C02");
