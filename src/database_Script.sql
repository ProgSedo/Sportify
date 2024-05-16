USE [master]
GO
/****** Object:  Database [UsersDB]    Script Date: 16.05.2024 21:05:51 ******/
CREATE DATABASE [UsersDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'UsersDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\UsersDB.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'UsersDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\UsersDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [UsersDB] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [UsersDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [UsersDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [UsersDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [UsersDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [UsersDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [UsersDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [UsersDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [UsersDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [UsersDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [UsersDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [UsersDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [UsersDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [UsersDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [UsersDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [UsersDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [UsersDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [UsersDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [UsersDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [UsersDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [UsersDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [UsersDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [UsersDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [UsersDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [UsersDB] SET RECOVERY FULL 
GO
ALTER DATABASE [UsersDB] SET  MULTI_USER 
GO
ALTER DATABASE [UsersDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [UsersDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [UsersDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [UsersDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [UsersDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [UsersDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'UsersDB', N'ON'
GO
ALTER DATABASE [UsersDB] SET QUERY_STORE = ON
GO
ALTER DATABASE [UsersDB] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [UsersDB]
GO
/****** Object:  User [as]    Script Date: 16.05.2024 21:05:51 ******/
CREATE USER [as] FOR LOGIN [as] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[football_forum]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[football_forum](
	[message] [varchar](50) NULL,
	[email] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[football_matches]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[football_matches](
	[eventID] [int] IDENTITY(4000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [int] NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_football_matches] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[football_tournaments]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[football_tournaments](
	[eventID] [int] IDENTITY(1000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [nchar](10) NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_football_tournaments] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tennis_forum]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tennis_forum](
	[message] [varchar](max) NULL,
	[email] [varchar](50) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tennis_matches]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tennis_matches](
	[eventID] [int] IDENTITY(4000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [int] NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_tennis_matches] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tennis_tournaments]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tennis_tournaments](
	[eventID] [int] IDENTITY(5000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [int] NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_tennis_tournaments] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[email] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[username] [varchar](50) NULL,
	[aboutMe] [varchar](max) NULL,
	[birthYear] [int] NULL,
	[eventID] [int] NULL,
	[doesTennis] [bit] NULL,
	[doesFootball] [bit] NULL,
	[doesVolleyball] [bit] NULL,
	[teamName] [varchar](50) NULL,
	[teamPassword] [varchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[volleyball_forum]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[volleyball_forum](
	[message] [varchar](max) NULL,
	[email] [varchar](50) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[volleyball_matches]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[volleyball_matches](
	[eventID] [int] IDENTITY(2000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [int] NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_volleyball_matches] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[volleyball_tournaments]    Script Date: 16.05.2024 21:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[volleyball_tournaments](
	[eventID] [int] IDENTITY(3000000,1) NOT NULL,
	[name] [varchar](50) NULL,
	[datetime] [datetime] NULL,
	[teamSize] [int] NULL,
	[place] [varchar](50) NULL,
	[details] [varchar](50) NULL,
	[isOver] [bit] NULL,
 CONSTRAINT [PK_volleyball_tournaments] PRIMARY KEY CLUSTERED 
(
	[eventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [UsersDB] SET  READ_WRITE 
GO
