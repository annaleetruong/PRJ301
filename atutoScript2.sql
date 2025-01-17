

CREATE DATABASE AssignmentPRJ301
GO

USE [AssignmentPRJ301]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 19/07/2023 11:04:17 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[userID] [varchar](50) NOT NULL,
	[proID] [varchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[phone] [varchar](50) NULL,
	[time] [datetime] NOT NULL,
 CONSTRAINT [pk_Invoice] PRIMARY KEY CLUSTERED 
(
	[time] ASC,
	[userID] ASC,
	[proID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 19/07/2023 11:04:17 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Products](
	[proID] [varchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](2000) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[srcImg] [varchar](100) NOT NULL,
	[sale] [bit] NOT NULL,
	[categoryID] [varchar](10) NOT NULL
PRIMARY KEY CLUSTERED 
(
	[proID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 19/07/2023 11:04:17 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [varchar](50) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[roleID] [varchar](2) NOT NULL,
	[isBanned] [bit] NOT NULL
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Categories] (
	[categoryID] [varchar](10) PRIMARY KEY,
	[categoryName] [nvarchar](30) NOT NULL
)


INSERT [dbo].[Products] ([proID], [name], [description], [price], [quantity], [srcImg], [sale], [categoryID])
VALUES ('A1', 'Bell pepper', 'Bell peppers are rich in nutrients including vitamin A, vitamin C and other nutrients. The vitamin A content in 149 grams of green bells provides about 551 IU of vitamin A, equivalent to one small cup. However, the vitamin A content in red bell peppers is more and better for the development of vision and eyes. Using one cup of chopped chilies in a variety of colors can provide more than 100% of the daily value.',6000, 1000, 'otchuong',1, 'C2'),
		('A2','Apple','Apples contain a lot of nutrients that are beneficial to your health such as Carb, fiber, sugar, fat, vitamin C, potassium, magnesium, etc',4000,2000,'tao',1,'C2'),
		('A3','Chilli','Chili contains many vitamins that are good for health. Chili is a spice that helps to enhance the taste of dishes or simply because of personal preference. Not only that, chili contains many times more nutrients than common vegetables.',1000,4000,'ot',1,'C2'),
		('A4','Purple Onion','Purple onion contains many nutrients and the content is also higher than white onion. Purple onions contain antioxidants with levels ranging from 415-1917 mg (white onions only have 270-1187 mg). Purple onions also contain high levels of vitamin C, biotin, chromium, calcium, vitamin B6, folic acid, sulfur and fiber, which are good for health. These nutrients all bring benefits to the body, each ingredient has its own use.',2000,3000,'hanhtim',1,'C1'),
		('A5','Cauliflower','Cruciferous vegetables like broccoli are especially nutritious because they are rich in vitamins and nutrients that improve heart health, fight cancer, and rebalance blood sugar. They are also low in calories and high in fiber, so they will make you feel full.',10000,2000,'suplo',1,'C1'),
		('A6','Garlic','Garlic is not only an essential spice in the kitchen, helping to increase the flavor of dishes, but also has many effects in the prevention and treatment of cardiovascular disease, cancer, infections, bones and joints.',2000,5000,'toi',1,'C1'),
		('A7','Tomato','Tomatoes are a rich source of fiber. Most of the fiber (87%) in tomatoes is in the insoluble form, in the form of hemicellulose, cellulose, and lignin.',4000,2000,'cachua',1,'C2'),
		('A8','Purple cabbage',N'Purple cabbage contains an abundant amount of vitamins necessary for the body such as vitamin K, calcium, magnesium, manganese and many minerals.',3000,2000,'bapcaitim',1,'C1')
GO


INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'cuong', N'Manh Cuong', N'123', N'US', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'admin', N'Admin', N'1', N'AD', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'ngan', N'Tuyet Ngan', N'1', N'AD', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'manhcuong', N'Tran Manh Cuong', N'1', N'AD', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'test1', N'test1', N'1', N'AD', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'test2', N'test2', N'1', N'US', 0)
INSERT [dbo].[Users] ([userID], [fullName], [password], [roleID], [isBanned]) VALUES (N'user', N'User', N'1', N'US', 0)
GO

INSERT [dbo].[Categories] ([categoryID],[categoryName]) VALUES ('C1','Vegetable')
INSERT [dbo].[Categories] ([categoryID],[categoryName]) VALUES ('C2','Fruit')
GO

ALTER TABLE [dbo].[Products] WITH CHECK ADD CONSTRAINT [fk_ProductCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Categories] ([categoryID])
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [fk_ProductCategory]
GO

ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [fk_ProductInvoice] FOREIGN KEY([proID])
REFERENCES [dbo].[Products] ([proID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [fk_ProductInvoice]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [fk_UsersInvoice] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [fk_UsersInvoice]
GO
