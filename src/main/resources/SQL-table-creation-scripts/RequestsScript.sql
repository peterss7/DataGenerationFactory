USE [PRS]
GO

/****** Object:  Table [dbo].[Requests]    Script Date: 2/8/2023 1:30:24 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Requests](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Description] [varchar](80) NOT NULL,
	[Justification] [varchar](80) NOT NULL,
	[RejectionReason] [varchar](80) NULL,
	[DeliveryMode] [varchar](20) NOT NULL,
	[SubmittedDate] [date] NOT NULL,
	[DateNeeded] [date] NOT NULL,
	[Status] [varchar](10) NOT NULL,
	[Total] [decimal](11, 2) NOT NULL,
	[UserID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Requests] ADD  DEFAULT ('Pickup') FOR [DeliveryMode]
GO

ALTER TABLE [dbo].[Requests] ADD  DEFAULT (getdate()) FOR [SubmittedDate]
GO

ALTER TABLE [dbo].[Requests] ADD  DEFAULT ('NEW') FOR [Status]
GO

ALTER TABLE [dbo].[Requests] ADD  DEFAULT ((0)) FOR [Total]
GO

ALTER TABLE [dbo].[Requests]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
GO

ALTER TABLE [dbo].[Requests]  WITH CHECK ADD  CONSTRAINT [fk_PRS_UserID] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
GO

ALTER TABLE [dbo].[Requests] CHECK CONSTRAINT [fk_PRS_UserID]
GO

