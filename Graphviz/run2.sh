tool=dot
tool=neato
#$tool -Tpng $1.dot >$1.png
#$tool -Tsvg $1.dot >$1.svg
for a in *.dot;
do
a2="${a%.*}"
$tool -Tsvg $a > $a2.svg
done
