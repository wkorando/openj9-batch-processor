(/usr/bin/time docker run --rm --name openj9_warm -v `pwd`/coredump:/coredump oj9d_openj9_quickstart_short_run_warm:latest > /dev/null) >> stats.txt 2>&1 && echo "openj9_warm" >> stats.txt

(/usr/bin/time docker run --rm --name openj9_cold -v `pwd`/coredump:/coredump oj9d_openj9_quickstart_short_run_cold:latest > /dev/null) >> stats.txt 2>&1 && echo "openj9_cold" >> stats.txt

(/usr/bin/time docker run --rm --name openj9_shared_cache -v `pwd`/coredump:/coredump --mount source=java-shared-classes,target=/cache oj9d_openj9_quickstart_short_run_shared_cache:latest > /dev/null) >> stats.txt 2>&1 && echo "openj9_shared_cache" >> stats.txt