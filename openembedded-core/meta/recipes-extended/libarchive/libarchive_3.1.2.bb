SUMMARY = "Support for reading various archive formats"
DESCRIPTION = "C library and command-line tools for reading and writing tar, cpio, zip, ISO, and other archive formats"
HOMEPAGE = "http://www.libarchive.org/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=b4e3ffd607d6686c6cb2f63394370841"

PACKAGECONFIG ?= "libxml2 zlib bz2"

PACKAGECONFIG_append_class-target = "\
	${@base_contains('DISTRO_FEATURES', 'acl', 'acl', '', d)} \
	${@base_contains('DISTRO_FEATURES', 'xattr', 'xattr', '', d)} \
	${@base_contains('DISTRO_FEATURES', 'largefile', 'largefile', '', d)} \
"

PACKAGECONFIG_append_class-nativesdk = " largefile"

PACKAGECONFIG[acl] = "--enable-acl,--disable-acl,acl,"
PACKAGECONFIG[xattr] = "--enable-xattr,--disable-xattr,attr,"
PACKAGECONFIG[largefile] = "--enable-largefile,--disable-largefile,,"
PACKAGECONFIG[zlib] = "--with-zlib,--without-zlib,zlib,"
PACKAGECONFIG[bz2] = "--with-bz2lib,--without-bz2lib,bzip2,"
PACKAGECONFIG[xz] = "--with-lzmadec --with-lzma,--without-lzmadec --without-lzma,xz,"
PACKAGECONFIG[openssl] = "--with-openssl,--without-openssl,openssl,"
PACKAGECONFIG[libxml2] = "--with-xml2,--without-xml2,libxml2,"
PACKAGECONFIG[expat] = "--with-expat,--without-expat,expat,"

SRC_URI = "http://libarchive.org/downloads/libarchive-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "efad5a503f66329bb9d2f4308b5de98a"
SRC_URI[sha256sum] = "eb87eacd8fe49e8d90c8fdc189813023ccc319c5e752b01fb6ad0cc7b2c53d5e"

inherit autotools lib_package

BBCLASSEXTEND = "native nativesdk"
