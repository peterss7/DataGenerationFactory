USE [PRS]
GO

/****** Object:  Table [dbo].[RequestLine]    Script Date: 2/8/2023 1:29:48 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RequestLine](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[RequestID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[RequestLine] ADD  DEFAULT ((1)) FOR [Quantity]
GO

ALTER TABLE [dbo].[RequestLine]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ID])
GO

ALTER TABLE [dbo].[RequestLine]  WITH CHECK ADD FOREIGN KEY([RequestID])
REFERENCES [dbo].[Requests] ([ID])
GO

ALTER TABLE [dbo].[RequestLine]  WITH CHECK ADD  CONSTRAINT [fk_PRS_ProductID] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ID])
GO

ALTER TABLE [dbo].[RequestLine] CHECK CONSTRAINT [fk_PRS_ProductID]
GO

ALTER TABLE [dbo].[RequestLine]  WITH CHECK ADD  CONSTRAINT [fk_PRS_RequestID] FOREIGN KEY([RequestID])
REFERENCES [dbo].[Requests] ([ID])
GO

ALTER TABLE [dbo].[RequestLine] CHECK CONSTRAINT [fk_PRS_RequestID]
GO

