/usr/bin/time docker run --name openj9_quickstart  oj9d_openj9_quickstart_short_run:latest > null && echo openJ9 quickstart &

/usr/bin/time docker run --name openj9_tuned  oj9d_openj9_tuned_short_run:latest > null && echo openJ9 tuned   &

/usr/bin/time docker run --name hotspot_baseline  oj9d_hotspot_baseline_short_run:latest > null && echo hotspot   &