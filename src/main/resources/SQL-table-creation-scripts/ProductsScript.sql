USE [PRS]
GO

/****** Object:  Table [dbo].[Products]    Script Date: 2/8/2023 1:30:07 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Products](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PartNumber] [varchar](30) NOT NULL,
	[Name] [varchar](30) NOT NULL,
	[Price] [decimal](11, 2) NOT NULL,
	[Unit] [varchar](30) NOT NULL,
	[PhotoPath] [varchar](255) NULL,
	[VendorID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[PartNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [fk_PRS_VendorID] FOREIGN KEY([VendorID])
REFERENCES [dbo].[Vendors] ([Id])
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [fk_PRS_VendorID]
GO

