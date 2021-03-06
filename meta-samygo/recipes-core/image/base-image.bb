DESCRIPTION = "A small image just capable of allowing a device to boot."
DEPENDS += "sysvinit" 
# samygoso apache2 dropbear mc patch usbutils strace setserial diffutils gawk grep groff gzip curl wget samba ser2net lua hexedit vim xclock oscam qemu v4l-utils yavta"

DEPENDS +="kmod-native"
require conf/distro/include/image-${MACHINE}.inc
QEMU_TARGETS = "arm mips mipsel i386"

IMAGE_VERSION = "${DISTRO_VERSION}"
IMAGE_NAME = "${DISTRO_NAME}-${IMAGE_VERSION}-${MACHINE}-${DATE}"
IMAGE_ROOTFS = "${TMPDIR}/rootfs"

IMAGE_LINK_NAME = ""
IMAGE_INSTALL = "opkg sysvinit samba ${ROOTFS_PKGMANAGE_BOOTSTRAP}"
IMAGE_FSTYPES = "jffs2 squashfs tar.bz2"
IMAGE_LINGUAS = " "

LICENSE = "MIT"


IMAGE_ROOTFS_SIZE = "8192"
BUILD_ALL_DEPS = "1"
inherit image
