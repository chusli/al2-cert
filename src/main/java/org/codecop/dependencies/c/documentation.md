# Einleitung

Diese Teilaufgabe setzte den Fokus erneut auf die Testbarmachung von Legacy Code mit direkter Infrastrukturkopplung.
Inhaltlich ähnelt sie stark den vorherigen Assignments und diente primär dazu, das bereits bekannte Vorgehen konsequent
anzuwenden.

# Commits

## Commit edd7e1e9

Es wurde ein Seam eingeführt, um die Klasse Checkout von der konkreten Persistenz über das SQL-Repository zu entkoppeln.
Durch das Extrahieren der Persistenzlogik konnte die eigentliche Berechnung des Receipts isoliert und sicher getestet
werden, ohne die öffentliche API zu verändern.

## Commit 64d8c588

Nur ein kleines Renaming des vorgegebenen Tests.

## Commit 47113e79

Der Seam wurde um einen Getter im Test-Fake ergänzt, sodass die erzeugten Receipt-Objekte im Test inspiziert werden
konnten. Dadurch liessen sich Amount, Tax und Total gezielt überprüfen und alle relevanten Pfade der Kernlogik abdecken.
Auch wenn nicht direkt nötig im Beispiel, fand ich es ok spezifische Tests pro Feld zu implementieren und nicht alle
Felder im gleichen Test zu prüfen.

# Fazit

Auch wenn die Aufgabe sehr kurz war und keine komplexen Business-Regeln enthielt, bestätigt sie erneut den Nutzen von
Seams zur Entkopplung von Seiteneffekten. Das Refactoring folgt demselben Muster wie in den vorherigen Aufgaben und
unterstreicht, wie bereits minimale strukturelle Änderungen die Testbarkeit deutlich verbessern.