CREATE
DATABASE nhom_7_ban_giay
drop
database nhom_7_ban_giay
USE nhom_7_ban_giay

CREATE TABLE LoaiGiay
(
    IdLoaiGiay int identity(1,1) PRIMARY KEY,
    MaLoai     varchar(10),
    TenLoai    nvarchar(30),
    TrangThai  bit
);
insert into LoaiGiay(MaLoai, TenLoai, TrangThai)
values ('l1', N'Loại 1', 1)
select *
from LoaiGiay

CREATE TABLE MauSac
(
    IdMau     int identity(1,1) PRIMARY KEY,
    MaMau     varchar(10),
    TenMau    nvarchar(30),
    TrangThai bit
);
insert into MauSac(MaMau, TenMau, TrangThai)
values ('mau1', N'Mau 1', 1)
select *
from MauSac

CREATE TABLE Size
(
    IdSize    int identity(1,1) PRIMARY KEY,
    MaSize    varchar(10),
    Size      float,
    TrangThai bit
);
insert into Size(MaSize, Size, TrangThai)
values ('S1', 39, 1)
select *
from Size

CREATE TABLE NhanHieu
(
    IdNhanHieu  int identity(1,1) PRIMARY KEY,
    MaNhanHieu  varchar(10),
    TenNhanHieu nvarchar(30),
    TrangThai   bit
);
insert into NhanHieu(MaNhanHieu, TenNhanHieu, TrangThai)
values ('NH1', N'Nhan hieu 1', 1)
select *
from NhanHieu

CREATE TABLE KieuDang
(
    IdKieuDang  int identity(1,1) PRIMARY KEY,
    MaKieuDang  varchar(10),
    TenKieuDang nvarchar(30),
    TrangThai   bit
);
insert into KieuDang(MaKieuDang, TenKieuDang, TrangThai)
values ('KD1', N'Kieu dang 1', 1)
select *
from KieuDang

CREATE TABLE DeGiay
(
    IdDeGiay   int identity(1,1) PRIMARY KEY,
    Ma         varchar(10),
    ChatLieu   nvarchar(30),
    ChieuCaoDe float,
    TrangThai  bit
);
insert into DeGiay(Ma, ChatLieu, ChieuCaoDe, TrangThai)
values ('DG1', N'Chat lieu 1', 2, 1)
select *
from DeGiay

CREATE TABLE GiayCT
(
    IdGiayCT   int identity(1,1) PRIMARY KEY,
    MaGiayCT   varchar(10),
    TenGiay    nvarchar(30),
    GiaNhap    decimal,
    GiaBan     decimal,
    SoLuongTon int,
    Anh        varchar(30),
    MoTa       nvarchar(40),
    TrangThai  bit,
    IdLoaiGiay int,
    IdMau      int,
    IdSize     int,
    IdNhanHieu int,
    IdKieuDang int,
    IdDeGiay   int
);
alter table GiayCT
    add IdKhuyenMaiGiay int insert into GiayCT(MaGiayCT, TenGiay, GiaNhap, GiaBan, SoLuongTon, Anh, MoTa, TrangThai, IdLoaiGiay, IdMau, IdSize, IdNhanHieu, IdKieuDang, IdDeGiay) values
('G10', N'Nike Air Huarache', 800000, 1300000, 20, 'giay9.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G3', N'Jordan 1 Retro', 800000, 1300000, 20, 'giay8.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G4', N'NIKE DUNK LOW', 800000, 1300000, 20, 'giay7.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G5', N'Lifestyle Nike Air', 800000, 1300000, 20, 'giay6.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G6', N'Nike Air Force 1', 800000, 1300000, 20, 'giay5.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G7', N'Unisex Nike Lebron', 800000, 1300000, 20, 'giay4.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G8', N'Nike Air TR', 800000, 1300000, 20, 'giay3.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1),
('G9', N'Nike Air ZoomX', 800000, 1300000, 20, 'giay2.jpg', 'N/A', 1, 1, 1, 1, 1, 1, 1)

select *
from GiayCT
alter table GiayCT drop column IdKhuyenMaiGiay
delete
from GiayCT
where IdGiayCT = 21

CREATE TABLE NhanVien
(
    IdNhanVien      int identity(1,1) PRIMARY KEY,
    MaNhanVien      varchar(10),
    HoVaTenNhanVien nvarchar(50),
    GioiTinh        bit,
    DiaChi          nvarchar(50),
    SDT             nvarchar(12),
    Email           nvarchar(20),
    cccd            varchar(13),
    TenTaiKhoan     varchar(20),
    MatKhau         varchar(20),
    ChucVu          int,
    TrangThai       bit,
    GhiChu          nvarchar(50)
);
insert into NhanVien(MaNhanVien, HoVaTenNhanVien, GioiTinh, DiaChi, SDT, TenTaiKhoan, MatKhau, ChucVu, TrangThai)
values ('NV1', N'Nguyễn Văn Hùng', 1, N'Hà Nội', '0987654321', 'HungNV', 'hung123', 2, 1)
select *
from NhanVien

CREATE TABLE KhachHang
(
    IdKhachHang int identity(1,1) PRIMARY KEY,
    MaKhachHang varchar(10),
    Hoten       nvarchar(50),
    GioiTinh    bit,
    NgaySinh    Date,
    DiaChi      nvarchar(50),
    SDT         nvarchar(13),
    Emai        nvarchar(30),
    TrangThai   bit,
    GhiChu      nvarchar(50)
);
select *
from KhachHang
delete
from KhachHang
where IdKhachHang = 2

drop table HoaDon
create TABLE HoaDon
(
    IdHoaDon      int identity(1,1) PRIMARY KEY,
    MaHoaDon      varchar(10),
    IdNhanVien    int,
    IdKhachHang   int null,
    TenKhachHang  nvarchar(50),
    NgayTao       date,
    TongTien      decimal,
    NgayThanhToan date,
    TrangThai     bit,
    GhiChu        nvarchar(50),
    NgayShip      date,
    TienShip      decimal,
    TienCoc       decimal,
    NgayNhan      date,
    DiaChi        nvarchar(50),
    TenNguoiShip  nvarchar(50),
    CCCDNguoiShip varchar(13),
    SDTNguoiShip  nvarchar(13),
    SDTNguoiNhan  nvarchar(13)
);
select *
from HoaDon
    insert
into HoaDon(MaHoaDon, IdNhanVien, TenKhachHang, NgayTao, TrangThai, SDTNguoiNhan)
values
    ('HD2', 1, N'Cao văn Hùng', GETDATE(), 0, '0987654398')
select *
from HoaDon

alter table HoaDon drop column GhiChu
alter table HoaDon drop column NgayShip
alter table HoaDon drop column TienShip
alter table HoaDon drop column TienCoc
alter table HoaDon drop column NgayNhan
alter table HoaDon drop column DiaChi
alter table HoaDon drop column TenNguoiShip
alter table HoaDon drop column CCCDNguoiShip
alter table HoaDon drop column SDTNguoiShip

delete
from HoaDon
where IdHoaDon = 13
--Đổi tên cột
          <!--EXEC sp_rename 'HoaDon.Id', 'IdHoaDon', 'COLUMN'; -->
drop table HoaDonChiTiet
CREATE TABLE HoaDonChiTiet
(
    IdGiayCT int,
    IdHoaDon int,
    Soluong  int,
    GiaBan   decimal
        PRIMARY KEY(IdGiayCT,IdHoaDon)
);
insert into HoaDonChiTiet
values (1, 2, 1, 1000000)
select *
from HoaDonChiTiet
where IdGiayCT = 8
delete
from HoaDonChiTiet
where IdGiayCT = 13

drop table KhuyenMai
CREATE TABLE KhuyenMai
(
    IdKhuyenMai  int identity(1,1) PRIMARY KEY,
    MaKhuyenMai  varchar(10),
    TenKhuyenMai nvarchar(50),
    NgayBatDau   date,
    NgayKetThuc  date,
    PhanTramGiam int,
    DieuKien     nvarchar(30),
    TrangThai    bit
);
select *
from KhuyenMai
delete
from KhuyenMai
where MaKhuyenMai = 'KM1'
update KhuyenMai
set TrangThai = 1
where MaKhuyenMai = 'KM4'

drop table KhuyenMaiGiay
CREATE TABLE KhuyenMaiGiay
(
    Id           int identity(1,1) primary key,
    IdGiayCT     int,
    IdKhuyenMai  int,
    GiaBan       decimal,
    GiaKhuyenMai decimal,
    TrangThai    bit
);
select *
from KhuyenMaiGiay
delete
from KhuyenMaiGiay
where IdGiayCT = 18

drop table DonDoiHang
CREATE TABLE DonDoiHang
(
    IdDon       int identity(1,1) PRIMARY KEY,
    NgayDoi     date,
    NgayMua     date,
    IdNhanVien  int,
    IdHoaDon    int,
    IdKhachHang int
);
drop table DoiHangCT
CREATE TABLE DoiHangCT
(
    Id            int identity(1,1) PRIMARY KEY,
    IdGiay        int,
    IdDon         int,
    SoLuong       int,
    TrangThaiGiay bit,
    LyDoDoiTra    nvarchar(50),
    MoTa          nvarchar(50),
);
--xóa cột
alter table DoiHangCT drop column IdHDCT
--Khóa ngoại Giày CT
ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_LoaiGiay
        FOREIGN KEY (IdLoaiGiay)
            REFERENCES LoaiGiay (IdLoaiGiay);

ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_MauSac
        FOREIGN KEY (IdMau)
            REFERENCES MauSac (IdMau);

ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_Size
        FOREIGN KEY (IdSize)
            REFERENCES Size (IdSize);

ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_NhanHieu
        FOREIGN KEY (IdNhanHieu)
            REFERENCES NhanHieu (IdNhanHieu);

ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_KieuDang
        FOREIGN KEY (IdKieuDang)
            REFERENCES KieuDang (IdKieuDang);

ALTER TABLE GiayCT
    ADD CONSTRAINT fk_GiayCT_id_DeGiay
        FOREIGN KEY (IdDeGiay)
            REFERENCES DeGiay (IdDeGiay);

--Khóa ngoại Khuyến mại giày

ALTER TABLE KhuyenMaiGiay
    ADD CONSTRAINT fk_KhuyenMaiGiay_id_GiayCT
        FOREIGN KEY (IdGiayCT)
            REFERENCES GiayCT (IdGiayCT);

ALTER TABLE KhuyenMaiGiay
    ADD CONSTRAINT fk_KhuyenMaiGiay_id_KhuyenMai
        FOREIGN KEY (IdKhuyenMai)
            REFERENCES KhuyenMai (IdKhuyenMai);

--Khóa ngoại Hóa Đơn Chi Tiết

ALTER TABLE HoaDonChiTiet
    ADD CONSTRAINT fk_HoaDonChiTiet_id_HoaDon
        FOREIGN KEY (IdHoaDon)
            REFERENCES HoaDon (IdHoaDon) on delete cascade;

ALTER TABLE HoaDonChiTiet
    ADD CONSTRAINT fk_HoaDonChiTiet_id_GiayCT
        FOREIGN KEY (IdGiayCT)
            REFERENCES GiayCT (IdGiayCT);

--Khóa ngoại Hóa Đơn

ALTER TABLE HoaDon
    ADD CONSTRAINT fk_HoaDon_id_NhanVien
        FOREIGN KEY (IdNhanVien)
            REFERENCES NhanVien (IdNhanVien);

ALTER TABLE HoaDon
    ADD CONSTRAINT fk_HoaDon_id_KhachHang
        FOREIGN KEY (IdKhachHang)
            REFERENCES KhachHang (IdKhachHang);

--Khóa ngoại Đơn Đổi Trả

ALTER TABLE DonDoiHang
    ADD CONSTRAINT fk_DonDoiHang_id_HoaDon
        FOREIGN KEY (IdHoaDon)
            REFERENCES HoaDon (IdHoaDon);

--Khóa ngoại Đổi Trả

ALTER TABLE DoiHangCT
    ADD CONSTRAINT fk_DoiHangCT_id_DonDoiHang
        FOREIGN KEY (IdDon)
            REFERENCES DonDoiHang (IdDon);

