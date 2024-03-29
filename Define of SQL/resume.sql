use zwf_resume_db;
drop table if exists resume;
create table resume (
                        id bigint primary key auto_increment comment '企业招聘表主键',
                        name varchar(100) not null comment '企业名称',
                        num int not null comment '招聘人数',
                        message text not null comment '企业介绍',
                        create_time DATE not null comment '创建时间',
                        update_time DATE not null comment '修改时间'
) comment = '企业信息表';

insert into resume value (null, '华为', 50, '华为创立于1987年，是全球领先的ICT（信息与通信）基础设施和智能终端提供商。我们的20.7万员工遍及170多个国家和地区，为全球30多亿人口提供服务。我们致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界。', '2024-02-25', '2024-02-25');
insert into resume value (null, '腾讯', 20, '腾讯公司成立于1998年，总部位于中国深圳，是一家以互联网服务为核心的跨国科技企业，也是中国最大的互联网综合服务提供商之一。腾讯的主要业务涉及互联网增值服务、在线广告、游戏、社交网络等领域。', '2024-02-26', '2024-02-26');
insert into resume value (null, '字节跳动', 10, '北京字节跳动科技有限公司是一家成立于2012年的信息科技公司，总部位于中国北京。字节跳动以建设“全球创作与交流平台”为愿景，是最早将人工智能应用于移动互联网场景的科技企业之一。', '2024-02-26', '2024-02-26');
insert into resume value (null, '网易', 25, '网易公司（NASDAQ:NTES）成立于1997年，是中国领先的互联网技术公司，也是中国主要门户网站之一。网易公司提供的服务包括门户网站、在线游戏、电子邮箱、在线教育、电子商务、在线音乐等。', '2024-02-26', '2024-02-26');
insert into resume value (null, '美团', 30, '美团是一家科技零售公司，成立于2010年3月，以“零售+科技”的战略践行“帮大家吃得更好，生活更好”的公司使命。自成立以来，美团持续推动服务零售和商品零售在需求侧和供给侧的数字化升级，与广大合作伙伴一起努力为消费者提供品质服务', '2024-02-25', '2024-02-25');
insert into resume value (null, '百度', 10, '百度（Baidu）是拥有强大互联网基础的领先AI公司。百度愿景是：成为最懂用户，并能帮助人们成长的全球顶级高科技公司。', '2024-02-27', '2024-02-27');
insert into resume value (null, '京东', 15, '京东（JD.com）是中国领先的技术驱动型电商和零售基础设施服务商，成立于2004年，并于2014年5月在美国纳斯达克证券交易所上市。京东集团创始人兼董事局主席是刘强东，总裁是徐雷', '2024-02-27', '2024-02-27');
insert into resume value (null, '阿里巴巴', 12, '阿里巴巴集团成立于1999年，总部位于中国杭州，是一家全球领先的小企业电子商务公司，也是阿里巴巴集团的旗舰业务。', '2024-02-27', '2024-02-27');
insert into resume value (null, '360', 60, '360公司，全称奇虎360，是一家中国的互联网和安全服务提供商，由周鸿祎创立于2005年。360公司以“让世界更安全更美好”为使命，致力于成为互联网和安全服务提供商。公司以“免费安全”战略颠覆了传统互联网安全行业模式，提高了中国网络安全的整体水平，开创了中国互联网的新格局。', '2024-02-28', '2024-02-28');
insert into resume value (null, '深信服', 10, '深信服科技股份有限公司是一家专注于企业级网络安全、云计算、IT基础设施与物联网的产品和服务供应商，拥有深信服智安全、信服云两大业务品牌，与子公司信锐技术，致力于承载各行业用户数字化转型过程中的基石性工作，从而让每个用户的数字化更简单、更安全。', '2024-02-28', '2024-02-28');
insert into resume value (null, '小米', 20, '小米是一家以手机、智能硬件和IoT平台为核心的互联网公司，以智能手机、智能电视、笔记本等丰富的产品与服务。致力于让全球每个人都能享受科技带来的美好生活', '2024-02-28', '2024-02-28');
insert into resume value (null, '大疆', 10, '大疆创新是深圳市大疆创新科技有限公司旗下的无人机品牌，创立于2006年。', '2024-02-28', '2024-02-28');
insert into resume value (null, '喜马拉雅', 30, '喜马拉雅是一款流行的音频平台和应用程序，提供广泛的音频内容，包括有声书、播客、音乐、广播剧、相声、情感故事等。它由中国上海的喜马拉雅科技有限公司开发，成立于2012年。喜马拉雅致力于用声音分享人类智慧，用声音服务美好生活，提供一家人一辈子的精神食粮', '2024-02-28', '2024-02-28');
insert into resume value (null, '米哈游', 20, '米哈游是一家成立于2012年的中国游戏公司，总部位于上海市徐汇区。公司由三位热爱技术和动漫文化的上海交通大学学生刘伟、蔡浩宇和罗宇皓共同创立。米哈游以制作动作游戏崩坏系列而闻名，并围绕原创IP打造了动画、漫画、游戏和小说等产品。', '2024-02-28', '2024-02-28');
insert into resume value (null, '快手', 10, '快手是中国流行的短视频和直播应用之一，由北京快手科技有限公司开发。', '2024-02-28', '2024-02-28');
insert into resume value (null, '哔哩哔哩', 30, 'B站早期是一个ACG(动画、漫画、游戏)内容创作与分享的视频网站。 经过十年多的发展，围绕用户、创作者和内容，构建了一个源源不断产生优质内容的生态系统，B站已经涵盖7000多个兴趣圈层的多元文化社区，曾获得QuestMobile研究院评选的"Z世代偏爱APP"和"Z世代偏爱泛娱乐APP"两项榜单第一名并入选"BrandZ"报告2019最具价值中国品牌100强.', '2024-02-28', '2024-02-28');
insert into resume value (null, '淘宝', 20, '淘宝网是中国杭州阿里巴巴集团旗下的一个网络零售平台，成立于2003年5月，是中国最大的网络实体店铺和各类零售供货商的汇集地。', '2024-02-28', '2024-02-28');
insert into resume value (null, '虎牙直播', 10, '虎牙直播是一家以游戏直播为核心的综合性娱乐社区。它提供高清、流畅的互动式视频直播服务，涵盖音乐、综艺、教育、户外、体育等多种直播内容。用户可以通过文字弹幕与主播实时互动，享受社交乐趣。虎牙直播的前身是YY游戏直播，于2014年11月24日更名为虎牙直播并开始独立运营。2015年5月28日，欢聚时代宣布成立欢聚时代互动娱乐事业部，虎牙直播与YY游戏、多玩游戏网共同组成“欢聚互娱”品牌。虎牙直播曾隶属于欢聚时代，并于2018年5月11日在纽约证券交易所挂牌交易。', '2024-02-28', '2024-02-28');