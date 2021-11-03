package org.bytedeco.proj.presets;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(
        value = {
                @Platform(include = "proj_api.h", link = "proj"),
        },
        target = "org.bytedeco.proj",
        global = "org.bytedeco.proj.global.proj"
)

public class proj implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "proj");
    }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("!defined(PROJECTS_H)").define(true));
        infoMap.put(new Info("PJ_VERSION", "pj_release", "pj_errno", "projUV", "projXY", "projLP",
                "pj_datum_transform", "pj_geocentric_to_geodetic", "pj_geodetic_to_geocentric",
                "pj_compare_datums", "pj_apply_gridshift", "pj_deallocate_grids", "pj_clear_initcache",
                "pj_is_latlong", "pj_is_geocent", "pj_get_spheroid_defn", "pj_pr_list",
                "pj_set_finder", "pj_set_searchpath", "pj_init",  "pj_get_def", "pj_latlong_from_proj",
                "pj_malloc", "pj_dalloc", "pj_strerrno", "pj_get_errno_ref", "pj_get_release", "pj_acquire_lock",
                "pj_release_lock", "pj_cleanup_lock", "pj_ctx_get_errno", "pj_ctx_set_errno",
                "pj_ctx_set_debug", "pj_ctx_set_logger", "pj_ctx_set_app_data", "pj_ctx_get_app_data", "pj_log",
                "pj_stderr_logger", "PJ_LOG_NONE", "PJ_LOG_ERROR", "PJ_LOG_DEBUG_MAJOR", "PJ_LOG_DEBUG_MINOR").skip());
    }
}
