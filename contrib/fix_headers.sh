#!/bin/bash
rg --files-without-match -F "$(head -1 ./LICENSE.HEADER.txt)" lib | awk '/.java$|.kt$|.groovy$/' | xargs -L 1 contrib/add_header.sh
