#!/bin/bash
if [ -f "$1" ]; then
	cat "./LICENSE.HEADER.txt" "$1" > "$1.new" && mv "$1.new" "$1"
fi
