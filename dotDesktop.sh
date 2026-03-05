#!/bin/bash

APP_NAME="LAMP Dashboard"
DESKTOP_FILE="$HOME/.local/share/applications/lamp-dashboard.desktop"

CURRENT_DIR="$(pwd)"

cat > "$DESKTOP_FILE" <<EOF
[Desktop Entry]
Version=1.0
Type=Application
Name=$APP_NAME
Comment=Gerenciador de containers LAMP
Exec=java -jar $CURRENT_DIR/dashboard/lamp-dashboard.jar
Icon=$CURRENT_DIR/dashboard/icon.png
Terminal=false
Categories=Development;
EOF

chmod +x "$DESKTOP_FILE"

echo "Instalado no menu de aplicativos!"